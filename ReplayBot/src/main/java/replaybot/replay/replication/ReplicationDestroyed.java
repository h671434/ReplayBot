package replaybot.replay.replication;

import replaybot.replay.property.CompressedWord;

public record ReplicationDestroyed(
		CompressedWord actorId) implements Replication {

	@Override
	public CompressedWord getActorId() {
		return actorId;
	}
	
}

