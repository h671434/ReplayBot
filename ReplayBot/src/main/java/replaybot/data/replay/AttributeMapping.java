package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeMapping {

	private int objectId;
	private int streamId;
	
	@JsonCreator
	public AttributeMapping(
			@JsonProperty("object_id") int objectId, 
			@JsonProperty("stream_id") int streamId) {
		this.objectId = objectId;
		this.streamId = streamId;
	}

	public int getObjectId() {
		return objectId;
	}

	public int getStreamId() {
		return streamId;
	}
	
}
