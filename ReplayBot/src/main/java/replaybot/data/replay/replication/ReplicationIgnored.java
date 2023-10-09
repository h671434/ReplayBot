package replaybot.data.replay.replication;

public class ReplicationIgnored implements ReplicationValue {

	@Override
	public void acceptVisit(ReplicationVisitor visitor) {
		// Ignore
	}

}
