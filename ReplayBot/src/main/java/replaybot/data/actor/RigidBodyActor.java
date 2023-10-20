package replaybot.data.actor;

import replaybot.data.attribute.RigidBody;

public abstract class RigidBodyActor extends Actor {

	private RigidBody rigidBodyState;
	
	public RigidBodyActor(int actorId) {
		super(actorId);
	}
	
	public RigidBodyActor(int actorId, RigidBody rigidBodyState) {
		super(actorId);
		this.rigidBodyState = rigidBodyState;
	}
	
	public RigidBody getRigidBodyState() {
		return rigidBodyState;
	}
	
	public void setRigidBodyState(RigidBody rigidBodyState) {
		this.rigidBodyState = rigidBodyState;
	}

}
