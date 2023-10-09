package replaybot.data.replay.replication;

import java.util.List;

public final class ReplicationUpdated implements ReplicationValue {

	private final List<ActorUpdater> updates;
	
	public ReplicationUpdated(List<ActorUpdater> updates) {
		this.updates = updates;
	}
	
	@Override
	public void acceptVisit(ReplicationVisitor visitor) {
		visitor.visit(this);
	}
	
	public List<ActorUpdater> getUpdates() {
		return updates;
	}
	
}