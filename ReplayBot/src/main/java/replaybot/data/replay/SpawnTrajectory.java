package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Rotation;
import replaybot.math.Vector3;

public class SpawnTrajectory {

	private final Vector3 location;
	private final Rotation rotation;

	@JsonCreator
	public SpawnTrajectory(
			@JsonProperty("location") Vector3 location,
			@JsonProperty("rotation") Vector3 rotation) {
		this.location = location;
		this.rotation = rotation;
	}

	public Vector3 getLocation() {
		return location;
	}
	
	public Rotation getRotation() {
		return rotation;
	}
	
}
