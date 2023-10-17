package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.data.attribute.Attribute;

public record UpdatedAttribute(
		@JsonProperty("actor_id") int actorId,
		@JsonProperty("stream_id") int streamId,
		@JsonProperty("object_id") int objectId,
		@JsonProperty("attribute") Attribute attribute) {
	


}
