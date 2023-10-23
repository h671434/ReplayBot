package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewActor {
    
	private final int actorId;
	private final int nameId;
	private final int objectId;
	private final SpawnTrajectory initialTrajectory;
	
	@JsonCreator
	public NewActor(
			@JsonProperty("actor_id") int actorId, 
			@JsonProperty("name_id") int nameId, 
			@JsonProperty("object_id") int objectId, 
			@JsonProperty("initial_trajectory") SpawnTrajectory initialTrajectory) {
		this.actorId = actorId;
		this.nameId = nameId;
		this.objectId = objectId;
		this.initialTrajectory = initialTrajectory;
	}

	public int getActorId() {
		return actorId;
	}

	public int getNameId() {
		return nameId;
	}

	public int getObjectId() {
		return objectId;
	}

	public SpawnTrajectory getInitialTrajectory() {
		return initialTrajectory;
	}
	
}
