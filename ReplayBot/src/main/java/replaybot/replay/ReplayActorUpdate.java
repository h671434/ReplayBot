package replaybot.replay;

import replaybot.data.input.RigidBodyState;
import replaybot.data.output.ControlsOutput;

public class ReplayActorUpdate {
		
	public final int actorId;
	private RigidBodyState rigidBody;
	
	public ReplayActorUpdate(int actorId, RigidBodyState rigidBody) {
		this.actorId = actorId;
		this.rigidBody = rigidBody;
	}
	
	public ReplayActorUpdate(int actorId) {
		this(actorId, null);
	}
	
	public boolean hasRigidBody() {
		return rigidBody != null;
	}
	
	public void setRigidBody(RigidBodyState rigidBody) {
		this.rigidBody = rigidBody;
	}
	
	public RigidBodyState getRigidBody() {
		return rigidBody;
	}
	
	
}
