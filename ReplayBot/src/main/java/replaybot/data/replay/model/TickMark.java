package replaybot.data.replay.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TickMark {

	private final String description;
	private final int frame;
	
	@JsonCreator
	public TickMark(
			@JsonProperty("description") String description,
			@JsonProperty("frame") int frame) {
		this.description = description;
		this.frame = frame;
	}

	public String getDescription() {
		return description;
	}

	public int getFrame() {
		return frame;
	}
	
}
