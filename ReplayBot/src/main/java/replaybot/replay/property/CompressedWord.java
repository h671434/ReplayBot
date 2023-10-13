package replaybot.replay.property;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CompressedWord(
		@JsonProperty("limit") int limit,
		@JsonProperty("value") int value) {

}
