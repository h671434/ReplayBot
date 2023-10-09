package replaybot.data.replay.replication;

public final class ReplicationDestroyed implements ReplicationValue {

	@Override
	public void acceptVisit(ReplicationVisitor visitor) {
		visitor.visit(this);
	}
	
}

