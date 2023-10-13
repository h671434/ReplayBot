package replaybot.replay.attribute;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.replay.property.BiasedVector3;
import replaybot.replay.property.Rotation;

public record ReplicatedRBState (
		@JsonProperty("sleeping")
		boolean sleeping,
		@JsonProperty("location")
		BiasedVector3 location, 
		@JsonProperty("rotation")
		@JsonIgnore
		Rotation rotation, 
		@JsonProperty("linear_velocity")
		BiasedVector3 linearVelocity, 
		@JsonProperty("angular_velocity")
		BiasedVector3 angularVelocity) {
	
}
