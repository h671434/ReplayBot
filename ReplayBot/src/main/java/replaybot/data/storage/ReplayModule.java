package replaybot.data.storage;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.module.SimpleModule;

import replaybot.data.attribute.Attribute;
import replaybot.data.replay.CacheProperty;
import replaybot.data.replay.ClassIndex;
import replaybot.data.replay.ClassNetCache;
import replaybot.data.replay.Frame;
import replaybot.data.replay.NetworkFrames;
import replaybot.data.replay.NewActor;
import replaybot.data.replay.Replay;
import replaybot.data.replay.Trajectory;
import replaybot.data.replay.UpdatedAttribute;
import replaybot.math.Rotation;
import replaybot.math.Vector3;

@SuppressWarnings("serial")
public class ReplayModule extends SimpleModule {

	public ReplayModule() {
		super("ReplayModule");
		setMixInAnnotation(Replay.class, ReplayMixin.class);
		setMixInAnnotation(NetworkFrames.class, NetworkFramesMixin.class);
		setMixInAnnotation(Frame.class, FrameMixin.class);
		setMixInAnnotation(NewActor.class, NewActorMixin.class);
		setMixInAnnotation(Trajectory.class, TrajectoryMixin.class);
		setMixInAnnotation(UpdatedAttribute.class, UpdatedAttributeMixin.class);
		setMixInAnnotation(ClassIndex.class, ClassIndexMixin.class);
		setMixInAnnotation(ClassNetCache.class, ClassNetCacheMixin.class);
		setMixInAnnotation(CacheProperty.class, CachePropertyMixin.class);
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static abstract class ReplayMixin {
		@JsonCreator
		public ReplayMixin(
				@JsonProperty("network_frames")
				NetworkFrames frames, 
				@JsonProperty("objects")
				List<String> objects, 
				@JsonProperty("names")
				List<String> names, 
				@JsonProperty("class_indices")
				List<ClassIndex> classIndices,
				@JsonProperty("net_cache")
				List<ClassNetCache> netCache) {
		}
	}
	
	private static abstract class NetworkFramesMixin {
		@JsonCreator
		public NetworkFramesMixin(
				@JsonProperty("frames")
				List<Frame> frames) {
		}
	}
	
	private static abstract class FrameMixin {
		@JsonCreator
		public FrameMixin(
				@JsonProperty("time")
				double time, 
				@JsonProperty("delta")
				double delta, 
				@JsonProperty("new_actors")
				List<NewActor> newActors, 
				@JsonProperty("updated_actors")
				List<UpdatedAttribute> updatedActors,
				@JsonProperty("deleted_actors")
				List<Integer> deletedActors) {
		}
	}
	
	private static abstract class NewActorMixin {
		@JsonCreator
		public NewActorMixin(
				@JsonProperty("actor_id")
				int actorId, 
				@JsonProperty("name_id")
				int nameId, 
				@JsonProperty("object_id")
				int objectid, 
				@JsonProperty("initial_trajectory")
				Trajectory initialTrajectory) {
		}
	}
	
	private static abstract class TrajectoryMixin {
		@JsonCreator
		public TrajectoryMixin(
				@JsonProperty("location")
				Vector3 location,
				@JsonProperty("rotation")
				Rotation rotation) {
		}
	}
	
	private static abstract class UpdatedAttributeMixin {
		@JsonCreator
		public UpdatedAttributeMixin(
				@JsonProperty("actor_id")
				int actorId, 
				@JsonProperty("stream_id")
				int streamId, 
				@JsonProperty("object_id")
				int objectId,
				@JsonProperty("attribute")
				Attribute attribute) {
		}
	}
	
	private static abstract class ClassIndexMixin {
		@JsonCreator
		public ClassIndexMixin(
				@JsonProperty("class")
				String className,
				@JsonProperty("index")
				int index) {
		}
	}
		
	private static abstract class ClassNetCacheMixin {
		@JsonCreator
		public ClassNetCacheMixin(
				@JsonProperty("object_ind")
				int objectIndex,
				@JsonProperty("parent_id")
				int parentId, 
				@JsonProperty("cache_id")
				int cacheId, 
				@JsonProperty("properties")
				List<CacheProperty> properties) {
		}
	}
	
	private static abstract class CachePropertyMixin {
		@JsonCreator
		public CachePropertyMixin(
				@JsonProperty("object_ind")
				int objectIndex,
				@JsonProperty("stream_id")
				int streamId) {
		}
	}
	
}
