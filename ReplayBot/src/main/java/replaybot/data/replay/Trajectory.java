package replaybot.data.replay;

import replaybot.math.Rotation;
import replaybot.math.Vector3;

public class Trajectory {

	private final Vector3 location;
	private final Rotation rotation;

	public Trajectory(Vector3 location, Rotation rotation) {
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
