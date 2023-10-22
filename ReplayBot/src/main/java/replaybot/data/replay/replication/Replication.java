package replaybot.data.replay.replication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.replay.storage.ReplicationDeserializer;

@JsonSubTypes({ 
	@Type(name = "spawned", value = ReplicationSpawned.class),
	@Type(name = "updated", value = ReplicationUpdated.class),
	@Type(name = "destroyed", value = ReplicationDestroyed.class) 
})
@JsonDeserialize(using = ReplicationDeserializer.class)
public abstract sealed class Replication permits ReplicationSpawned, ReplicationUpdated, ReplicationDestroyed {

	private int actorId;
	
	public Replication(int actorId) {
		this.actorId = actorId;
	}
	
	public int getActorId() {
		return actorId;
	}
	
}
