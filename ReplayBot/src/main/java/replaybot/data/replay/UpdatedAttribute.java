package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.data.replay.attribute.Attribute;

public class UpdatedAttribute {
	
	private final int actorId;
	private final int streamId;
	private final int objectId;
	private final Attribute attribute;
	
	@JsonCreator
	public UpdatedAttribute(
			@JsonProperty("actor_id") int actorId, 
			@JsonProperty("stream_id") int streamId, 
			@JsonProperty("object_id") int objectId,
			@JsonProperty("attribute") Attribute attribute) {
		this.actorId = actorId;
		this.streamId = streamId;
		this.objectId = objectId;
		this.attribute = attribute;
	}

	public int getActorId() {
		return actorId;
	}

	public int getStreamId() {
		return streamId;
	}

	public int getObjectId() {
		return objectId;
	}

	public Attribute getAttribute() {
		return attribute;
	}

}
