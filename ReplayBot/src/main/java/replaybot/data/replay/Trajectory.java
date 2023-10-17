package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Vector3;

public class Trajectory {

	private final Vector3 location;
	private final Vector3 rotation;

	public Trajectory(Vector3 location, Vector3 rotation) {
		this.location = location;
		this.rotation = rotation;
	}

}
