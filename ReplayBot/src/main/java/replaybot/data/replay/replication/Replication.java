package replaybot.data.replay.replication;

import replaybot.data.replay.actor.Actor;

public abstract class Replication {
	
	private final int actorId;
	private final ReplicationValue value;
	
	public Replication(int actorId, ReplicationValue value) {
		this.actorId = actorId;
		this.value = value;
	}
	
	public void acceptVisitValue(ReplicationVisitor visitor) {
		value.acceptVisit(visitor);
	}
	
	public int getActorId() {
		return actorId;
	}
	
	public ReplicationValue getValue() {
		return value;
	}
	
}
