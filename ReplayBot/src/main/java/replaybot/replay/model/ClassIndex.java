package replaybot.replay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClassIndex(
		@JsonProperty("class") String className,
		@JsonProperty("index") int index) {

}
