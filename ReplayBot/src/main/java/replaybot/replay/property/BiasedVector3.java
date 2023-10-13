package replaybot.replay.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public record BiasedVector3(
		@JsonProperty("bias") 
		int bias, 
		@JsonProperty("size") 
		CompressedWord size, 
		double x, 
		double y, 
		double z) {

}
