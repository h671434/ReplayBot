package replaybot.data.replay;

import java.util.List;

public class Frame {
	
	private final double time;
	private final double delta;
	private final List<NewActor> newActors;
	private final List<UpdatedAttribute> updatedActors;
	private final List<Integer> deletedActors;
	
	public Frame(double time, double delta, List<NewActor> newActors, List<UpdatedAttribute> updatedActors,
			List<Integer> deletedActors) {
		this.time = time;
		this.delta = delta;
		this.newActors = newActors;
		this.updatedActors = updatedActors;
		this.deletedActors = deletedActors;
	}
	
}
