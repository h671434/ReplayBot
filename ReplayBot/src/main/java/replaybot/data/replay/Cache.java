package replaybot.data.replay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cache {

	private int classId;
	private int parentCacheId;
	private int cacheId;
	private List<AttributeMapping> attributeMappings;
	
	@JsonCreator
	public Cache(
			@JsonProperty("attribute_mappings") List<AttributeMapping> attributeMappings,
			@JsonProperty("cache_id") int cacheId, 
			@JsonProperty("class_id") int classId, 
			@JsonProperty("parent_cache_id") int parentCacheId) {
		this.classId = classId;
		this.parentCacheId = parentCacheId;
		this.cacheId = cacheId;
		this.attributeMappings = attributeMappings;
	}

	public int getClassId() {
		return classId;
	}

	public int getParentCacheId() {
		return parentCacheId;
	}

	public int getCacheId() {
		return cacheId;
	}

	public List<AttributeMapping> getAttributeMappings() {
		return attributeMappings;
	}
	
}
