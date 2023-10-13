package replaybot.replay.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public record BiasedVector3(
		@JsonProperty("bias") 
		int bias, 
		@JsonProperty("size") 
		CompressedWord size, 
		@JsonProperty("x") 
		double x, 
		@JsonProperty("y") 
		double y, 
		@JsonProperty("z") 
		double z) {

}
