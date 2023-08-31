package replaybot.data.replay.updatedactor;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.data.replay.Replay;
import replaybot.data.rigidbody.RigidBody;
import replaybot.math.Vector3;

public class UpdatedActorDeserializer extends StdDeserializer<UpdatedActor> {
	static int i = 0;

	public UpdatedActorDeserializer() {
		this(null);
	}
	
	public UpdatedActorDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public UpdatedActor deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		System.out.println("ua" + i++);
		return new UpdatedRigidBody(i, new RigidBody());
	}
	
	private RigidBody deserializeRigidBody(JsonNode rigidBodyNode) {
		Vector3 location = deserializeVector(rigidBodyNode.get("location"));
		Vector3 rotation = deserializeVector(rigidBodyNode.get("roation"));
		Vector3 linearVelocity = deserializeVector(rigidBodyNode.get("linear_velocity"));
		Vector3 angularVelocity = deserializeVector(rigidBodyNode.get("angular_velocity"));
		
		return new RigidBody(location, rotation, linearVelocity, angularVelocity);
	}
	
	private Vector3 deserializeVector(JsonNode vectorNode) {
		double x = vectorNode.get("x").doubleValue();
		double y = vectorNode.get("y").doubleValue();
		double z = vectorNode.get("z").doubleValue();
		
		return new Vector3(x, y, z);
	}

}
