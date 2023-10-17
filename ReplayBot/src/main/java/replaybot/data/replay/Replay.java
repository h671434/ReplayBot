package replaybot.data.replay;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.storage.AttributeDeserializer;
import replaybot.data.storage.ReplayDeserializer;

@JsonDeserialize(using = ReplayDeserializer.class)
public record Replay(
		List<Frame> frames,
		List<String> objects,
		List<String> names,
		List<ClassIndex> classIndices,
		List<NetCache> netCache) {
	
	
}
