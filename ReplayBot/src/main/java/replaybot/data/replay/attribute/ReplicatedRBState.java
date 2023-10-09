package replaybot.data.replay.attribute;

import replaybot.data.RigidBody;

public class ReplicatedRBState {

	private boolean sleeping;
	private RigidBody rigidBody;
	
	public ReplicatedRBState(boolean sleeping, RigidBody rigidBody) {
		this.sleeping = sleeping;
		this.rigidBody = rigidBody;
	}
	
	public boolean isSleeping() {
		return sleeping;
	}
	
	public RigidBody getRigidBody() {
		return rigidBody;
	}
	
}
