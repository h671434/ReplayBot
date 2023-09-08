package replaybot.data.replay.actor;

import replaybot.data.RigidBody;

public abstract class RigidBodyActor extends Actor {

	private RigidBody rigidBody;
	
	public RigidBodyActor(int id) {
		super(id);
	}
	
	@Override
	public void updateProperty(ActorUpdateProperty<?> property) {
		if(property.getName() == "TAGame.RBActor_TA:ReplicatedRBState" && property.isRigidBody()) {
			setRigidBody(property.getRigidBody());
		}
	}
	
	private void setRigidBody(RigidBody rigidBody) {
		this.rigidBody = rigidBody;
	}
	
	public RigidBody getRigidBody() {
		return rigidBody;
	}

}
