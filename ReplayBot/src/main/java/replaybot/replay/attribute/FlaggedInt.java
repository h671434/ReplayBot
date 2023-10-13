package replaybot.replay.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FlaggedInt(
		@JsonProperty("flag") boolean flag, 
		@JsonProperty("int") int intValue) {

}
