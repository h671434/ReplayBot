package replaybot.replay;

import java.util.List;
import java.util.Map;

import replaybot.replay.actorupdate.ReplayUpdatedActor;

public class ReplayFrame {

	private final double time;
	private final double delta;
	private final List<ReplayUpdatedActor> updatedActors;
	
	public ReplayFrame(double time, double delta, List<ReplayUpdatedActor> updatedActors) {
		this.time = time;
		this.delta = delta;
		this.updatedActors = updatedActors;
	}
	

}
