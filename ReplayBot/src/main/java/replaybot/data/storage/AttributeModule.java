package replaybot.data.storage;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import replaybot.data.attribute.ActiveActor;
import replaybot.data.attribute.Attribute;
import replaybot.data.attribute.Demolish;
import replaybot.data.attribute.RigidBody;
import replaybot.math.Quaternion;
import replaybot.math.Rotation;
import replaybot.math.Vector3;

@SuppressWarnings("serial")
public class AttributeModule extends SimpleModule {

	public AttributeModule() {
		super("AttributeModule");
		addDeserializer(Attribute.class, new AttributeDeserializer());
		setMixInAnnotation(ActiveActor.class, ActiveActorMixin.class);
		setMixInAnnotation(RigidBody.class, RigidBodyMixin.class);
		setMixInAnnotation(Demolish.class, DemolishMixin.class);
	}
	
	private static class AttributeDeserializer extends StdDeserializer<Attribute> {
		
		public AttributeDeserializer() {
			super(Attribute.class);
		}

		@Override
		public Attribute deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
			if(p.currentToken() != JsonToken.START_OBJECT) {
				p.nextToken();
			}
			
			p.nextValue();
			
			Attribute result = switch(p.currentName()) {
			case "Byte" -> new Attribute.Byte(p.getByteValue());
			case "Boolean" -> new Attribute.Boolean(p.getBooleanValue());
			case "Int" -> new Attribute.Int(p.getIntValue());
			case "Float" -> new Attribute.Float(p.getFloatValue()); 
			case "String" -> new Attribute.String(p.getText());
			case "Rotation" -> new Attribute.Rotation(p.readValueAs(Rotation.class));
			case "ActiveActor" -> new Attribute.ActiveActor(p.readValueAs(ActiveActor.class)); 
			case "RigidBody" -> new Attribute.RigidBody(p.readValueAs(RigidBody.class));
			case "Demolish" -> new Attribute.Demolish(p.readValueAs(Demolish.class));
			default -> new Attribute.NotImplemented();
			};
			
			if(result instanceof Attribute.NotImplemented) {
				p.skipChildren();
			}
			
			return result;
		}
		
	}
	
	private static abstract class ActiveActorMixin {
		@JsonCreator
		public ActiveActorMixin(
				@JsonProperty("active")
				boolean active,
				@JsonProperty("actor")
				int actorId) {
		}
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static abstract class RigidBodyMixin {
		@JsonCreator
		public RigidBodyMixin(
				@JsonProperty("location")
				Vector3 location,
				@JsonProperty("rotation")
				Rotation rotation,
				@JsonProperty("linear_velocity")
				Vector3 linearValocity,
				@JsonProperty("angular_velocity")
				Vector3 angularVelocity) {
		}
	}
	
	private static abstract class DemolishMixin {
		@JsonCreator
		public DemolishMixin(
				@JsonProperty("attacker_flag")
				boolean attackerFlag, 
				@JsonProperty("attacker")
				int attackerActorId, 
				@JsonProperty("victim_flag")
				boolean victimFlag, 
				@JsonProperty("victim")
				int victimActorId,
				@JsonProperty("attack_velocity")
				Vector3 attackVelocity, 
				@JsonProperty("victim_velocity")
				Vector3 victimVelocity) {
		}
	}
	
}
