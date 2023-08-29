package replaybot.replay;

import java.util.List;
import java.util.Map;

public class ReplayFrame {

	private final double time;
	private final double delta;
	private final List<ReplayActorUpdate> updatedActors;
	
	public ReplayFrame(double time, double delta, List<ReplayActorUpdate> updatedActors) {
		this.time = time;
		this.delta = delta;
		this.updatedActors = updatedActors;
	}
	

}
