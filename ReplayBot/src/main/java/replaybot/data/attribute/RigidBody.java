package replaybot.data.attribute;

import replaybot.math.Rotation;
import replaybot.math.Vector3;

public class RigidBody {
	
	private final Vector3 location;
	private final Rotation rotation;
	private final Vector3 linearVelocity;
	private final Vector3 angularVelocity;
	
	public RigidBody(Vector3 location, Rotation rotation, Vector3 linearVelocity,
			Vector3 angularVelocity) {
		this.location = location;
		this.rotation = rotation;
		this.linearVelocity = linearVelocity;
		this.angularVelocity = angularVelocity;
	}

	public Vector3 getLocation() {
		return location;
	}

	public Rotation getRotation() {
		return rotation;
	}

	public Vector3 getLinearVelocity() {
		return linearVelocity;
	}

	public Vector3 getAngularVelocity() {
		return angularVelocity;
	}
	
}
