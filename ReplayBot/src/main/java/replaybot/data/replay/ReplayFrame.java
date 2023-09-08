package replaybot.data.replay;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.replay.actor.ActorUpdate;

public class ReplayFrame {
	
	private final double time;
	private final double delta;
	private final List<Integer> deletedActorIds;
	private final List<ActorUpdate> updatedActors;
	
	public ReplayFrame(double time, double delta, List<Integer> deletedActorIds, List<ActorUpdate> updatedActors) {
		this.time = time;
		this.delta = delta;
		this.deletedActorIds = Collections.unmodifiableList(deletedActorIds);
		this.updatedActors = Collections.unmodifiableList(updatedActors);
	}
	
	public double getTime() {
		return time;
	}

	public double getDelta() {
		return delta;
	}

	public int getDeletedActorId(int index) {
		return deletedActorIds.get(index);
	}
	
	public List<Integer> getAllDeletedActorIds() {
		return deletedActorIds;
	}
	
	public int amountOfDeletedActors() {
		return deletedActorIds.size();
	}

	public ActorUpdate getUpdatedActor(int index) {
		return updatedActors.get(index);
	}
	
	public List<ActorUpdate> getAllUpdatedActors() {
		return updatedActors;
	}

	public int amountOfUpdatedActors() {
		return updatedActors.size();
	}

}
