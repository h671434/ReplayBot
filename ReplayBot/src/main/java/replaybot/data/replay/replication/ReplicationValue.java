package replaybot.data.replay.replication;

import replaybot.data.replay.actor.Actor;

public interface ReplicationValue {

	public void acceptVisit(ReplicationVisitor visitor);
	
}
