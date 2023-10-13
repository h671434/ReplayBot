package replaybot.replay.replication;

import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.replay.property.CompressedWord;

public record ReplicationDestroyed(
		CompressedWord actorId) implements Replication {

	@Override
	public CompressedWord getActorId() {
		return actorId;
	}
	
}

