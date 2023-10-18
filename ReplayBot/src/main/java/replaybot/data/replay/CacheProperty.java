package replaybot.data.replay;

public class CacheProperty {
	
	private final int objectIndex;
	private final int streamId;
	
	public CacheProperty(int objectIndex, int streamId) {
		this.objectIndex = objectIndex;
		this.streamId = streamId;
	}

	public int getObjectIndex() {
		return objectIndex;
	}

	public int getStreamId() {
		return streamId;
	}
	
}
