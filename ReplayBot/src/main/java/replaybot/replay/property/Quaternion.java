package replaybot.replay.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("quaternion")
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
