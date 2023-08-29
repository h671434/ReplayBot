package replaybot.data.input;

import replaybot.math.Vector3;

public class RigidBodyState {

	public final Vector3 location;
	public final Vector3 rotation;
	public final Vector3 linearVelocity;
	public final Vector3 angularVelocity;
	
	public RigidBodyState(Vector3 location, Vector3 rotation, Vector3 linearVelocity,
			Vector3 angularVelocity) {
		this.location = location;
		this.rotation = rotation;
		this.linearVelocity = linearVelocity;
		this.angularVelocity = angularVelocity;
	}
	
	public RigidBodyState(rlbot.flat.Physics physics) {
		this.location = new Vector3(physics.location());
		this.rotation = new Vector3(physics.rotation());
		this.linearVelocity = new Vector3(physics.velocity());
		this.angularVelocity = new Vector3(physics.angularVelocity());
	}
	
}
