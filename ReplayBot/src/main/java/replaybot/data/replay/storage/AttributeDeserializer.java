package replaybot.data.replay.storage;

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

import replaybot.data.replay.attribute.ActiveActor;
import replaybot.data.replay.attribute.Attribute;
import replaybot.data.replay.attribute.RigidBody;
import replaybot.math.Quaternion;
import replaybot.math.Rotation;
import replaybot.math.Vector3;

public class AttributeDeserializer extends StdDeserializer<Attribute> {
	
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
		default -> new Attribute.NotImplemented();
		};
		
		if(result instanceof Attribute.NotImplemented) {
			p.skipChildren();
		}
		
		return result;
	}
	
}
