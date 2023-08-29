package replaybot.replay;

import java.util.List;

public class Replay {

	private final ReplayProperties properties;
	private final List<ReplayFrame> frames;
	private final List<String> objects;
	
	public Replay(ReplayProperties properties, List<ReplayFrame> frames, 
			List<String> objects) {
		this.properties = properties;
		this.frames = frames;
		this.objects = objects;
	}
	
}
