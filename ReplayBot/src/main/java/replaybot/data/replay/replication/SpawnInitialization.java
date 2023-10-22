package replaybot.data.replay.replication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Rotation;
import replaybot.math.Vector3;

public class SpawnInitialization {

	private final Vector3 location;
	private final Rotation rotation;

	@JsonCreator
	public SpawnInitialization(
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
