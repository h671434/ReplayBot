package replaybot.data.replay;

import java.util.List;

public class ClassNetCache {
	
	private final int objectIndex;
	private final int parentId;
	private final int cacheId;
	private final List<CacheProperty> properties;
	
	public ClassNetCache(int objectIndex, int parentId, int cacheId, List<CacheProperty> properties) {
		this.objectIndex = objectIndex;
		this.parentId = parentId;
		this.cacheId = cacheId;
		this.properties = properties;
	}

	public int getObjectIndex() {
		return objectIndex;
	}

	public int getParentId() {
		return parentId;
	}

	public int getCacheId() {
		return cacheId;
	}

	public List<CacheProperty> getProperties() {
		return properties;
	}

}
