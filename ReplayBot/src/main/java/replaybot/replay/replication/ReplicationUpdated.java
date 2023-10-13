package replaybot.replay.replication;

import java.util.List;

import replaybot.replay.property.CompressedWord;

public record ReplicationUpdated(
		CompressedWord actorId,
		List<UpdatedAttribute<?>> updates) implements Replication {

	@Override
	public CompressedWord getActorId() {
		return actorId;
	}
	
}