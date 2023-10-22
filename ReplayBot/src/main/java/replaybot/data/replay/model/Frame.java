package replaybot.data.replay.model;

import java.util.List;
import java.util.function.Consumer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Frame {
	
	private final double time;
	private final double delta;
	private final List<NewActor> newActors;
	private final List<UpdatedAttribute> updatedActors;
	private final List<Integer> deletedActors;
	
	@JsonCreator
	public Frame(				
			@JsonProperty("time") double time, 
			@JsonProperty("delta") double delta, 
			@JsonProperty("new_actors") List<NewActor> newActors, 
			@JsonProperty("updated_actors") List<UpdatedAttribute> updatedActors,
			@JsonProperty("deleted_actors") List<Integer> deletedActors) {
		this.time = time;
		this.delta = delta;
		this.newActors = newActors;
		this.updatedActors = updatedActors;
		this.deletedActors = deletedActors;
	}
	
	public void processNewActors(Consumer<NewActor> process) {
		newActors.forEach(process);
	}
	
	public void processUpdatedActors(Consumer<UpdatedAttribute> process) {
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
	
	public List<UpdatedAttribute> getUpdated() {
		return updatedActors;
	}
	
}
