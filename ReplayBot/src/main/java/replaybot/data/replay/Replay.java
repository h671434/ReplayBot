package replaybot.data.replay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import replaybot.data.actor.Actor;

public class Replay {
	
	private final ReplayProperties properties;
	private final NetworkFrames frames;
	private final List<TickMark> tickMarks;
	private final List<String> objects;
	 
	private Map<Integer, Actor> actorsById = new HashMap<>();
	
	public Replay(ReplayProperties properties, NetworkFrames frames, List<TickMark> tickMarks, List<String> objects) {
		this.properties = properties;
		this.frames = frames;
		this.tickMarks = tickMarks;
		this.objects = objects;
	}
	
	public void processNextFrame() {
		Frame frame = frames.next();
		
		frame.processNewActors(this::createNewActor);
		frame.processUpdatedActors(this::updateActor);
		frame.processDeletedActors(this::deleteActor);
	}
	
	public void createNewActor(NewActor data) {
		String object = objects.get(data.getObjectId());
		
		//
	}
	
	public void updateActor(UpdatedAttribute data) {
		Actor actor = actorsById.get(data.getActorId());
		String field = objects.get(data.getObjectId());
		
		actor.setField(field, data.getAttribute());
	}
	
	public void deleteActor(int actorId)  {
		actorsById.remove(actorId);
	}

	public ReplayProperties getProperties() {
		return properties;
	}

	public List<TickMark> getTickMarks() {
		return tickMarks;
	}
	
}
