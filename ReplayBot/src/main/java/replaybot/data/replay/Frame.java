package replaybot.data.replay;

import java.util.List;
import java.util.function.Consumer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.data.replay.replication.ReplicationSpawned;
import replaybot.data.replay.replication.ReplicationUpdated;

public class Frame {
	
	private final double time;
	private final double delta;
	private final List<ReplicationSpawned> newActors;
	private final List<ReplicationUpdated> updatedActors;
	private final List<Integer> deletedActors;
	
	@JsonCreator
	public Frame(				
			@JsonProperty("time") double time, 
			@JsonProperty("delta") double delta, 
			@JsonProperty("new_actors") List<ReplicationSpawned> newActors, 
			@JsonProperty("updated_actors") List<ReplicationUpdated> updatedActors,
			@JsonProperty("deleted_actors") List<Integer> deletedActors) {
		this.time = time;
		this.delta = delta;
		this.newActors = newActors;
		this.updatedActors = updatedActors;
		this.deletedActors = deletedActors;
	}
	
	public void processNewActors(Consumer<ReplicationSpawned> process) {
		newActors.forEach(process);
	}
	
	public void processUpdatedActors(Consumer<ReplicationUpdated> process) {
		updatedActors.forEach(process);
	}
	
	public void processDeletedActors(Consumer<Integer> process) {
		deletedActors.forEach(process);
	}

	public double getTime() {
		return time;
	}

	public double getDelta() {
		return delta;
	}
	
	public List<ReplicationUpdated> getUpdated() {
		return updatedActors;
	}
	
}
