package replaybot.data.replay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Replay {
	
	private final ReplayProperties properties;
	private final NetworkFrames frames;
	private final List<Mark> tickMarks;
	private final List<String> objects;
	
	@JsonCreator
	public Replay(
			@JsonProperty("properties")	ReplayProperties properties,
			@JsonProperty("network_frames") NetworkFrames frames, 
			@JsonProperty("tick_marks") List<Mark> tickMarks, 
			@JsonProperty("objects") List<String> objects) {
		this.properties = properties;
		this.frames = frames;
		this.tickMarks = tickMarks;
		this.objects = objects;
	}

	public ReplayProperties getProperties() {
		return properties;
	}

	public List<Mark> getTickMarks() {
		return tickMarks;
	}
	
}
