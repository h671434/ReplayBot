package replaybot.data.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ActiveActor(
		@JsonProperty("active") boolean active,
		@JsonProperty("actor") int actorId) {

}
