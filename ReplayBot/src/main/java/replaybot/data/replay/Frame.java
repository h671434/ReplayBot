package replaybot.data.replay;

import java.util.List;

import replaybot.data.replay.replication.Replication;

public class Frame {

	private final double time;
	private final double delta;
	private final List<Replication> replications;
	
	public Frame(double time, double delta, List<Replication> replications) {
		this.time = time;
		this.delta = delta;
		this.replications = replications;
	}
	
}
