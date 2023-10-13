package replaybot.replay.property;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IntVector3(
		@JsonProperty("x")
		int x,
		@JsonProperty("y")
		int y,
		@JsonProperty("z")
		int z) {

}
