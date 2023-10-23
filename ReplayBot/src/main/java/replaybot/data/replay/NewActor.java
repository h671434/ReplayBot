package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewActor {
    
	private final int actorId;
	private final int objectId;
	private final SpawnTrajectory initialTrajectory;
	
	@JsonCreator
	public NewActor(
			@JsonProperty("actor_id") int actorId, 
			@JsonProperty("object_id") int objectId, 
			@JsonProperty("initial_trajectory") SpawnTrajectory initialTrajectory) {
		this.actorId = actorId;
		this.objectId = objectId;
		this.initialTrajectory = initialTrajectory;
	}

	public int getActorId() {
		return actorId;
	}

	public int getObjectId() {
		return objectId;
	}

	public SpawnTrajectory getInitialTrajectory() {
		return initialTrajectory;
	}
	
}
