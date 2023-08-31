package replaybot.replay;

import java.util.List;

public class Replay {

	private final ReplayProperties properties;
	private final List<ReplayFrame> frames;
	
	public Replay(ReplayProperties properties, List<ReplayFrame> frames) {
		this.properties = properties;
		this.frames = frames;
	}
	
}
