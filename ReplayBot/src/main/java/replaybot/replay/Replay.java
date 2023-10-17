package replaybot.replay;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.replay.model.ClassIndex;
import replaybot.replay.model.Frame;
import replaybot.replay.model.NetCache;
import replaybot.replay.storage.AttributeDeserializer;
import replaybot.replay.storage.ReplayDeserializer;

@JsonDeserialize(using = ReplayDeserializer.class)
public record Replay(
		List<Frame> frames,
		List<String> objects,
		List<String> names,
		List<ClassIndex> classIndices,
		List<NetCache> netCache) {
	
	
}
