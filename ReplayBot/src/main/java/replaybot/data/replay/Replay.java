package replaybot.data.replay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.data.actor.Actor;

public class Replay {
	
	private final HeaderProperties properties;
	private final NetworkFrames frames;
	private final List<TickMark> tickMarks;
	private final List<String> objects;
	private final List<String> names;
	private final List<ClassIndex> classIndices;
	private final List<ClassNetCache> netCache;
	 
	private Map<Integer, Actor> actorsById = new HashMap<>();
	
	
	public Replay(HeaderProperties properties, NetworkFrames frames, List<TickMark> tickMarks, List<String> objects, 
			List<String> names, List<ClassIndex> classIndices, List<ClassNetCache> netCache) {
		this.properties = properties;
		this.frames = frames;
		this.tickMarks = tickMarks;
		this.objects = objects;
		this.names = names;
		this.classIndices = classIndices;
		this.netCache = netCache;
	}
	
	public void processNextFrame() {
		Frame frame = frames.next();
		
		frame.processNewActors(this::createNewActor);
		frame.processUpdatedActors(this::updateActor);
		frame.processDeletedActors(this::deleteActor);
	}
	
	public void createNewActor(NewActor data) {
		String object = objects.get(data.getObjectId());
		
		Actor actor = switch(object) {
		default -> null; // TODO
		};
		
		
		actorsById.put(data.getActorId(), actor);
	}
	
	public void updateActor(UpdatedAttribute data) {
		Actor actor = actorsById.get(data.getActorId());
		
	}
	
	public void deleteActor(int actorId)  {
		actorsById.remove(actorId);
	}

	public HeaderProperties getProperties() {
		return properties;
	}
	
	public NetworkFrames getFrames() {
		return frames;
	}

	public List<TickMark> getTickMarks() {
		return tickMarks;
	}

	public List<String> getObjects() {
		return objects;
	}

	public List<String> getNames() {
		return names;
	}

	public List<ClassIndex> getClassIndices() {
		return classIndices;
	}

	public List<ClassNetCache> getNetCache() {
		return netCache;
	}
	
}
