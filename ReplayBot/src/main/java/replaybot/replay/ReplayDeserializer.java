package replaybot.replay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.data.input.RigidBodyState;
import replaybot.data.output.ControlsOutput;
import replaybot.math.Vector3;

public class ReplayDeserializer extends StdDeserializer<Replay>{

	private static final String RB_STATE_UPDATE = "TAGame.RBActor_TA:ReplicatedRBState";
	
	private List<String> objects;
	
	public ReplayDeserializer() {
		this(null);
	}
	
	public ReplayDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Replay deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		JsonNode replayNode = jp.getCodec().readTree(jp);
		JsonNode propertiesNode = replayNode.get("properties");
		JsonNode objectsNode = replayNode.get("objects");
		JsonNode framesNode = replayNode.get("network_frames").get("frames");
		
		objects = deserializeObjects(objectsNode);
		ReplayProperties properties = deserializeProperties(propertiesNode);
		List<ReplayFrame> frames = deserializeFrames(framesNode);
		
		return new Replay(properties, frames);
	}
	
	private List<String> deserializeObjects(JsonNode objectsNode) {
		List<String> objects = new ArrayList<>();
		
		objectsNode.elements().forEachRemaining((JsonNode objectNode) -> {
			objects.add(objectNode.textValue());
		});
		
		return objects;
	}
	
	private ReplayProperties deserializeProperties(JsonNode propertiesNode) {
		//TODO
		return null;
	}
	
	private List<ReplayFrame> deserializeFrames(JsonNode framesNode) {
		List<ReplayFrame> frames = new ArrayList<>();
		
		framesNode.elements().forEachRemaining((JsonNode frameNode) -> {
			frames.add(deserializeFrame(frameNode));
		});
		
		return frames;
	}
	
	private ReplayFrame deserializeFrame(JsonNode frameNode) {
		double time = frameNode.get("time").doubleValue();
		double delta = frameNode.get("delta").doubleValue();
		
		//TODO
		
		return new ReplayFrame(time, delta, null /*TODO*/);
	}
	
	
	private RigidBodyState deserializeRigidBody(JsonNode rigidBodyNode) {
		Vector3 location = deserializeVector(rigidBodyNode.get("location"));
		Vector3 rotation = deserializeVector(rigidBodyNode.get("roation"));
		Vector3 linearVelocity = deserializeVector(rigidBodyNode.get("linear_velocity"));
		Vector3 angularVelocity = deserializeVector(rigidBodyNode.get("angular_velocity"));
		
		return new RigidBodyState(location, rotation, linearVelocity, angularVelocity);
	}
	
	private Vector3 deserializeVector(JsonNode vectorNode) {
		double x = vectorNode.get("x").doubleValue();
		double y = vectorNode.get("y").doubleValue();
		double z = vectorNode.get("z").doubleValue();
		
		return new Vector3(x, y, z);
	}
 
}
