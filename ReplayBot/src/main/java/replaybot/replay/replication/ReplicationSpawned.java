package replaybot.replay.replication;

import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Vector3;
import replaybot.replay.property.CompressedWord;
import replaybot.replay.property.Initialization;

public record ReplicationSpawned(
		CompressedWord actorId,
		String className,
		boolean flag,
		Initialization initialization,
		String name,
		int nameIndex,
		int objectId,
		String objectName) implements Replication {

	@Override
	public CompressedWord getActorId() {
		return actorId;
	}
	
}
