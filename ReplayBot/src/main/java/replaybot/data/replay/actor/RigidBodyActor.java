package replaybot.data.replay.actor;

import replaybot.data.RigidBody;

public abstract class RigidBodyActor extends Actor {

	private ActorUpdateProperties.ReplicatedRigidBody rigidBody;
	
	public RigidBodyActor(int id) {
		super(id);
	}
	
	@Override
	public void updateProperty(ActorUpdateProperty<?> property) {
		if("TAGame.RBActor_TA:ReplicatedRBState".equals(property.getName()) && property.isRigidBody()) {
			rigidBody = property.getRigidBody();
		}
	}
	
	public RigidBody getRigidBody() {
		return rigidBody;
	}

}
