package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.replay.attribute.Attribute;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedAttribute {
	
	private final int actorId;
	private final int objectId;
	private final Attribute attribute;
	
	@JsonCreator
	public UpdatedAttribute(
			@JsonProperty("actor_id") int actorId, 
			@JsonProperty("object_id") int objectId,
			@JsonProperty("attribute") Attribute attribute) {
		this.actorId = actorId;
		this.objectId = objectId;
		this.attribute = attribute;
	}

	public int getActorId() {
		return actorId;
	}

	public int getObjectId() {
		return objectId;
	}
	
	public Attribute getAttribute() {
		return attribute;
	}

}
