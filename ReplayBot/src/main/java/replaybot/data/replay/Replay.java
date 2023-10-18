package replaybot.data.replay;

import java.util.List;

public class Replay {
	
	private final NetworkFrames frames;
	private final List<String> objects;
	private final List<String> names;
	private final List<ClassIndex> classIndices;
	private final List<ClassNetCache> netCache;
	
	public Replay(NetworkFrames frames, List<String> objects, List<String> names, List<ClassIndex> classIndices,
			List<ClassNetCache> netCache) {
		this.frames = frames;
		this.objects = objects;
		this.names = names;
		this.classIndices = classIndices;
		this.netCache = netCache;
	}
	
}
