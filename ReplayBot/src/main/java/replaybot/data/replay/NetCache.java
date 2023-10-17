package replaybot.data.replay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NetCache(
		@JsonProperty("object_ind") int objectIndex,
		@JsonProperty("parent_id") int parentId,
		@JsonProperty("cache_id") int cacheId,
		@JsonProperty("properties") List<Property> properties)  {
	
	public record Property(
			@JsonProperty("object_ind") int objectIndex,
			@JsonProperty("stream_id") int streamId) {
		
	}

}
