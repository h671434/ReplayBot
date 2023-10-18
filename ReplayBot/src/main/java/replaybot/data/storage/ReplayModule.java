package replaybot.data.storage;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.module.SimpleModule;

import replaybot.data.attribute.Attribute;
import replaybot.data.replay.CacheProperty;
import replaybot.data.replay.ClassIndex;
import replaybot.data.replay.ClassNetCache;
import replaybot.data.replay.Frame;
import replaybot.data.replay.HeaderProperties;
import replaybot.data.replay.NetworkFrames;
import replaybot.data.replay.NewActor;
import replaybot.data.replay.Replay;
import replaybot.data.replay.TickMark;
import replaybot.data.replay.Trajectory;
import replaybot.data.replay.UpdatedAttribute;
import replaybot.math.Rotation;
import replaybot.math.Vector3;

@SuppressWarnings("serial")
public class ReplayModule extends SimpleModule {

	public ReplayModule() {
		super("ReplayModule");
		setMixInAnnotation(Replay.class, ReplayMixIn.class);
		setMixInAnnotation(HeaderProperties.class, HeaderPropertiesMixIn.class);
		setMixInAnnotation(NetworkFrames.class, NetworkFramesMixIn.class);
		setMixInAnnotation(Frame.class, FrameMixIn.class);
		setMixInAnnotation(NewActor.class, NewActorMixIn.class);
		setMixInAnnotation(Trajectory.class, TrajectoryMixIn.class);
		setMixInAnnotation(UpdatedAttribute.class, UpdatedAttributeMixIn.class);
		setMixInAnnotation(TickMark.class, TickMarkMixIn.class);
		setMixInAnnotation(ClassIndex.class, ClassIndexMixIn.class);
		setMixInAnnotation(ClassNetCache.class, ClassNetCacheMixIn.class);
		setMixInAnnotation(CacheProperty.class, CachePropertyMixIn.class);
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static abstract class ReplayMixIn {
		@JsonCreator
		public ReplayMixIn(
				@JsonProperty("properties")
				HeaderProperties properties,
				@JsonProperty("network_frames")
				NetworkFrames frames, 
				@JsonProperty("tick_marks")
				List<TickMark> tickMarks, 
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
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static abstract class HeaderPropertiesMixIn {
		@JsonCreator
		public HeaderPropertiesMixIn(
				@JsonProperty("TeamSize")
				int teamSize, 
				@JsonProperty("Team0Score")
				int team0Score, 
				@JsonProperty("Team1Score")
				int team1Score, 
				@JsonProperty("ReplayName")
				String replayName, 
				@JsonProperty("Id")
				String id, 
				@JsonProperty("Date")
				@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm-ss")
				Date date,
				@JsonProperty("NumFrames")
				int numFrames) {
		}
	}
	
	private static abstract class NetworkFramesMixIn {
		@JsonCreator
		public NetworkFramesMixIn(
				@JsonProperty("frames")
				List<Frame> frames) {
		}
	}
	
	private static abstract class FrameMixIn {
		@JsonCreator
		public FrameMixIn(
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
	
	private static abstract class NewActorMixIn {
		@JsonCreator
		public NewActorMixIn(
				@JsonProperty("actor_id")
				int actorId, 
				@JsonProperty("name_id")
				int nameId, 
				@JsonProperty("object_id")
				int objectId, 
				@JsonProperty("initial_trajectory")
				Trajectory initialTrajectory) {
		}
	}
	
	private static abstract class TrajectoryMixIn {
		@JsonCreator
		public TrajectoryMixIn(
				@JsonProperty("location")
				Vector3 location,
				@JsonProperty("rotation")
				Rotation rotation) {
		}
	}
	
	private static abstract class UpdatedAttributeMixIn {
		@JsonCreator
		public UpdatedAttributeMixIn(
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
	
	private static abstract class TickMarkMixIn {
		@JsonCreator
		public TickMarkMixIn(
				@JsonProperty("description")
				String description,
				@JsonProperty("frame")
				int frame) {
		}
	}
	
	private static abstract class ClassIndexMixIn {
		@JsonCreator
		public ClassIndexMixIn(
				@JsonProperty("class")
				String className,
				@JsonProperty("index")
				int index) {
		}
	}
		
	private static abstract class ClassNetCacheMixIn {
		@JsonCreator
		public ClassNetCacheMixIn(
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
	
	private static abstract class CachePropertyMixIn {
		@JsonCreator
		public CachePropertyMixIn(
				@JsonProperty("object_ind")
				int objectIndex,
				@JsonProperty("stream_id")
				int streamId) {
		}
	}
	
}
