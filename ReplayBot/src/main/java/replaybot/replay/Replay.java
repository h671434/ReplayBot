package replaybot.replay;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.replay.storage.ReplayDeserializer;

@JsonDeserialize(using = ReplayDeserializer.class)
public record Replay(
		List<ReplayFrame> frames) {
	
	
}
