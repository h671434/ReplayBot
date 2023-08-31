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

import replaybot.data.input.RigidBody;
import replaybot.data.output.ControlsOutput;
import replaybot.math.Vector3;
import replaybot.replay.actorupdate.ReplayUpdatedActor;
import replaybot.replay.actorupdate.ReplayUpdatedActorFactory;

public class ReplayDeserializer extends StdDeserializer<Replay>{
	
	private JsonNode rootNode;
	
	public ReplayDeserializer() {
		this(null);
	}
	
	public ReplayDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Replay deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		rootNode = jp.getCodec().readTree(jp);
		
		JsonNode propertiesNode = rootNode.get("properties");
		JsonNode framesNode = rootNode.get("network_frames").get("frames");
		
		ReplayProperties properties = deserializeProperties(propertiesNode);
		List<ReplayFrame> frames = deserializeAllFrames(framesNode);
		
		return new Replay(properties, frames);
	}
	
	private ReplayProperties deserializeProperties(JsonNode propertiesNode) {
		//TODO
		return null;
	}
	
	private List<ReplayFrame> deserializeAllFrames(JsonNode frameArrayNode) {
		List<ReplayFrame> frames = new ArrayList<>();
		
		frameArrayNode.elements().forEachRemaining((JsonNode frameNode) -> {
			frames.add(deserializeFrame(frameNode));
		});
		
		return frames;
	}
	
	private ReplayFrame deserializeFrame(JsonNode frameNode) {
		double time = frameNode.get("time").doubleValue();
		double delta = frameNode.get("delta").doubleValue();
		
		JsonNode updatedActorsNode = frameNode.get("updated_actors");
		List<ReplayUpdatedActor> updatedActors = deserializeAllUpdatedActors(updatedActorsNode);
		
		return new ReplayFrame(time, delta, updatedActors);
	}
	
	private List<ReplayUpdatedActor> deserializeAllUpdatedActors(JsonNode updatedActorArrayNode) {
		List<ReplayUpdatedActor> updatedActors = new ArrayList<>();
		
		updatedActorArrayNode.elements().forEachRemaining((JsonNode updatedActorNode) -> {
			updatedActors.add(deserializeUpdatedActor(updatedActorNode));
		});;
		
		return updatedActors;
	}
	
	private ReplayUpdatedActor deserializeUpdatedActor(JsonNode updatedActorNode) {
		int actorId = updatedActorNode.get("actor_id").intValue();
		int objectId = updatedActorNode.get("object_id").intValue();
		String object = rootNode.get("objects").get(objectId).textValue();
		Object attribute = deserializeUpdatedActorAttribute(updatedActorNode.get("attribute"));
		
		return ReplayUpdatedActorFactory.createUpdatedActor(actorId, object, attribute);
	}
	
	private Object deserializeUpdatedActorAttribute(JsonNode attributeNode) {
		
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
