package replaybot.data.replay.storage;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.module.SimpleModule;

import replaybot.math.Quaternion;
import replaybot.math.Rotation;
import replaybot.math.RotationVector;
import replaybot.math.Vector3;

@SuppressWarnings("serial")
public class MathModule extends SimpleModule {
	
	public MathModule() {
		super("MathModule");
		setMixInAnnotation(Rotation.class, RotationMixin.class);
		setMixInAnnotation(Vector3.class, Vector3Mixin.class);
		setMixInAnnotation(Quaternion.class, QuaternionMixin.class);
	}
	
	
	@JsonSubTypes({
		@Type(value = Vector3.class),
        @Type(value = Quaternion.class)
    })
	@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = Quaternion.class)
	private static abstract class RotationMixin {}
	
	private static abstract class Vector3Mixin {
		@JsonCreator
		public Vector3Mixin(
				@JsonProperty("x") @JsonAlias("pitch") double x, 
				@JsonProperty("y") @JsonAlias("roll") double y,
				@JsonProperty("z") @JsonAlias("yaw") double z) {
		}
	}
	
	private static abstract class QuaternionMixin {
		@JsonCreator
		public QuaternionMixin(
				@JsonProperty("x") double x, 
				@JsonProperty("y") double y,
				@JsonProperty("z") double z,
				@JsonProperty("w") double w) {
		}
	}
	
}
