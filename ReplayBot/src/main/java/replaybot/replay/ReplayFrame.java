package replaybot.replay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.replay.replication.Replication;
import replaybot.replay.storage.ReplicationDeserializer;

public record ReplayFrame (
		@JsonProperty("time") 
		double time, 
		@JsonProperty("delta") 
		double delta, 
		@JsonProperty("replications") 
		List<Replication> replications) {
	
}
