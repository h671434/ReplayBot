package replaybot.data.replay;

import replaybot.data.attribute.Attribute;

public class UpdatedAttribute {
	
	private final int actorId;
	private final int streamId;
	private final int objectId;
	private final Attribute attribute;
	
	public UpdatedAttribute(int actorId, int streamId, int objectId, Attribute attribute) {
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
