package replaybot.replay.actorupdate;

import replaybot.data.input.RigidBody;

public class ReplayUpdatedRigidBody implements ReplayUpdatedActor {

	private final int actorId;
	private final RigidBody rigidBody;
	
	public ReplayUpdatedRigidBody(int actorId, RigidBody rigidBody) {
		this.actorId = actorId;
		this.rigidBody = rigidBody;
	}
	
	@Override
	public void applyActorUpdate() {
		// TODO Auto-generated method stub
		
	}
	
}
