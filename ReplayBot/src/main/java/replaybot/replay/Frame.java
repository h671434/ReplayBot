package replaybot.replay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.replay.replication.Replication;

public record Frame (
		@JsonProperty("time") double time, 
		@JsonProperty("time") double delta, 
		@JsonProperty("time") List<Replication> replications) {
	
}
