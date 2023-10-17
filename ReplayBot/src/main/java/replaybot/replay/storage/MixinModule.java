package replaybot.replay.storage;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import replaybot.data.RigidBody;
import replaybot.math.Quaternion;
import replaybot.math.Rotation;
import replaybot.math.Vector;
import replaybot.math.Vector3;
import replaybot.replay.model.Trajectory;

public class MixinModule extends SimpleModule {
	
	public MixinModule() {
		super("MixinModule");
		init();
	}
	
	private void init() {
		setMixInAnnotation(Vector3.class, Vector3Mixin.class);
		setMixInAnnotation(Rotation.class, RotationMixin.class);
		setMixInAnnotation(Quaternion.class, QuaternionMixin.class);
		setMixInAnnotation(Trajectory.class, TrajectoryMixin.class);
		setMixInAnnotation(RigidBody.class, RigidBodyMixin.class);
	}
	
	private static abstract class Vector3Mixin {
		
		@JsonCreator
		public Vector3Mixin(
				@JsonProperty("x") double x, 
				@JsonProperty("y") double y,
				@JsonProperty("z") double z) {
		}
		
	}
	
	private static abstract class RotationMixin {
		
		@JsonCreator
		public RotationMixin(
				@JsonProperty("pitch") double pitch, 
				@JsonProperty("yaw") double yaw,
				@JsonProperty("roll") double roll) {	
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
	
	private static abstract class TrajectoryMixin {
		
		@JsonCreator
		public TrajectoryMixin(
				@JsonProperty("location") Vector3 location, 
				@JsonProperty("rotation") Rotation rotation) {
			
		}
		
	}
	
	@JsonIgnoreProperties(value = ("sleeping"))
	private static abstract class RigidBodyMixin {
			
			@JsonCreator
			public RigidBodyMixin(
					@JsonProperty("location") Vector3 location,
					@JsonProperty("rotation") Quaternion rotation,
					@JsonProperty("linear_velocity") Vector3 linearVelocity,
					@JsonProperty("angular_velocity") Vector3 angularVelocity) {
				
			}

	}
	
}
