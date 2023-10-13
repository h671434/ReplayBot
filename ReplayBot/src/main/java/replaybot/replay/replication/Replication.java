package replaybot.replay.replication;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.replay.property.CompressedWord;
import replaybot.replay.storage.ReplicationDeserializer;

@JsonSubTypes({
    @JsonSubTypes.Type(value = ReplicationSpawned.class),
    @JsonSubTypes.Type(value = ReplicationUpdated.class),
    @JsonSubTypes.Type(value = ReplicationDestroyed.class)
})
@JsonDeserialize(using = ReplicationDeserializer.class)
public interface Replication {
	
	public CompressedWord getActorId();
	
}
