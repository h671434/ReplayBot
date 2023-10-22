package replaybot.data.replay.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Rotation;
import replaybot.math.Vector3;

public class Trajectory {

	private final Vector3 location;
	private final Rotation rotation;

	@JsonCreator
	public Trajectory(
			@JsonProperty("location") Vector3 location,
			@JsonProperty("rotation") Rotation rotation) {
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
