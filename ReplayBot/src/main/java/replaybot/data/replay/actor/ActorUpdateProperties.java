package replaybot.data.replay.actor;

import replaybot.data.RigidBody;
import replaybot.math.Vector3;

public class ActorUpdateProperties {

	public static class ActiveActor {
		
		public final boolean active;
		public final int actorId;
		
		public ActiveActor(boolean active, int actorId) {
			this.actorId = actorId;
			this.active = active;
		}
		
	}
	
	public static class ReplicatedRigidBody extends RigidBody {
		
		public final boolean sleeping;
		
		public ReplicatedRigidBody(Vector3 location, Vector3 rotation, Vector3 linearVelocity,
				Vector3 angularVelocity, boolean sleeping) {
			super(location, rotation, linearVelocity, angularVelocity);
			this.sleeping = sleeping;
		}
		
	}
 	
}
