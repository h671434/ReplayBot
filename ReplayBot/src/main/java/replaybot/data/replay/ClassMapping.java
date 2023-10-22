package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassMapping {
	
	private String name;
	private int streamId;
	
	@JsonCreator
	public ClassMapping(
			@JsonProperty("name") String name, 
			@JsonProperty("stream_id") int streamId) {
		this.name = name;
		this.streamId = streamId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStreamId() {
		return streamId;
	}

}
