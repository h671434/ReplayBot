package replaybot.data.replay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.data.DataPacket;
import replaybot.data.replay.actor.ActorFactory;
import replaybot.data.replay.actor.ReplicatedActor;
import replaybot.data.replay.attribute.Attribute;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Replay {
	
	private final ReplayProperties properties;
	private final NetworkFrames frames;
	private final List<TickMark> tickMarks;
	private final List<String> objects;
	
	private ActorFactory actorFactory = new ActorFactory();
	private Map<Integer, ReplicatedActor> actorsById = new HashMap<>();
	
	@JsonCreator
	public Replay(
			@JsonProperty("properties")	ReplayProperties properties,
			@JsonProperty("network_frames") NetworkFrames frames, 
			@JsonProperty("tick_marks") List<TickMark> tickMarks, 
			@JsonProperty("objects") List<String> objects) {
		this.properties = properties;
		this.frames = frames;
		this.tickMarks = tickMarks;
		this.objects = objects;
	}
	
	public void simulateNextFrame() {
		Frame frame = frames.next();
		
		frame.processNewActors(this::createActor);
		frame.processUpdatedActors(this::updateActor);
		frame.processDeletedActors(this::deleteActor);
	}
	
	public void createActor(NewActor spawnData) {
		String object = objects.get(spawnData.getObjectId());
		ReplicatedActor actor = actorFactory.createFrom(object, spawnData.getInitialTrajectory());
		
		actorsById.put(spawnData.getActorId(), actor);
	}
	
	public void updateActor(UpdatedAttribute updateData) {
		ReplicatedActor actor = actorsById.get(updateData.getActorId());
		String field = objects.get(updateData.getObjectId());
		
		try {
			actor.setField(field, updateData.getAttribute());
		} catch(ClassCastException e) {
			System.err.println("Casting failed for " + field + " with attribute " + updateData.getAttribute());
		}
	}
	
	public void deleteActor(int actorId) {
		actorsById.remove(actorId);
	}
	
	public DataPacket buildDataPacket() {
		return null; // TODO
	}

	public ReplayProperties getProperties() {
		return properties;
	}

	public List<TickMark> getTickMarks() {
		return tickMarks;
	}
	
}
