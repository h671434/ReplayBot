package replaybot.data.replay.updatedactor;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.rigidbody.RigidBody;

@JsonDeserialize(using = UpdatedActorDeserializer.class)
public class UpdatedRigidBody implements UpdatedActor {

	private final int actorId;
	private final RigidBody rigidBody;
	
	public UpdatedRigidBody(int actorId, RigidBody rigidBody) {
		this.actorId = actorId;
		this.rigidBody = rigidBody;

	}
	
	@Override
	public void applyActorUpdate() {
		// TODO Auto-generated method stub
		
	}
	
}
