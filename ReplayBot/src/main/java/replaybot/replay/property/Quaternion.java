package replaybot.replay.property;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Quaternion(
		@JsonProperty("w")
		double w,
		@JsonProperty("x")
		double x,
		@JsonProperty("y")
		double y,
		@JsonProperty("z")
		double z) implements Rotation {

}
