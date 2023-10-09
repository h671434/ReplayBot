package replaybot.data.replay.replication;

import replaybot.data.replay.actor.Actor;

public final class ReplicationSpawned implements ReplicationValue {

	private final Actor spawnedActor;
	
	public ReplicationSpawned(Actor spawnedActor) {
		this.spawnedActor = spawnedActor;
	}
	
	@Override
	public void acceptVisit(ReplicationVisitor visitor) {
		visitor.visit(this);
	}
	
	public Actor getSpawnedActor() {
		return spawnedActor;
	}

}
