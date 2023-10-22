package replaybot.data.replay.replication;

import com.fasterxml.jackson.annotation.JsonCreator;

public final class ReplicationDestroyed extends Replication {

	public ReplicationDestroyed(int actorId) {
		super(actorId);
	}
	
}
