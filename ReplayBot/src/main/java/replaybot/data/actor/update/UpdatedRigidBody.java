package replaybot.data.actor.update;

import replaybot.data.actor.Actor;
import replaybot.data.attribute.RigidBody;

public class UpdatedRigidBody implements ActorUpdate {

	private final RigidBody rigidBody;
	
	public UpdatedRigidBody(RigidBody rigidBody) {
		this.rigidBody = rigidBody;
	}
	
	@Override
	public void update(Actor actor) {
		// TODO Auto-generated method stub
		
	}

}
