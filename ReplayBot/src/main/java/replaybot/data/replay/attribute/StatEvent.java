package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatEvent {

	private final boolean flag;
	private final int objectId;
	
	public StatEvent(
			@JsonProperty("unknown1") boolean flag, 
			@JsonProperty("object_id") int objectId) {
		this.flag = flag;
		this.objectId = objectId;
	}

	public boolean isFlag() {
		return flag;
	}

	public int getObjectId() {
		return objectId;
	}
	
}
