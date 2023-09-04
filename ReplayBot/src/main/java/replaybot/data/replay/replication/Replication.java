package replaybot.data.replay.replication;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

import replaybot.util.Wrapper;

public abstract class Replication {
	
	protected final int actorId;
	
	public Replication() {
		this(0);
	}
	
	public Replication(int actorId) {
		this.actorId = actorId;
	}
	
}
