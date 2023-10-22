package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompressedWord {

	private int limit;
	private int value;
	
	@JsonCreator
	private CompressedWord(
			@JsonProperty("limit") int limit,
			@JsonProperty("value") int value) {
		this.limit = limit;
		this.value = value;
	}
}
