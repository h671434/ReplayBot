package replaybot.replay.property;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Initialization(
		@JsonProperty("location")
		BiasedVector3 location,
		@JsonProperty("rotation")
		IntVector3 rotation) {

}
