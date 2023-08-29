package replaybot.replay;

import java.util.List;
import java.util.Map;

public class ReplayFrame {

	public final double time;
	public final double delta;
	public final Map<Integer, ReplayActorUpdate> actorUpdatesById;
	
	public ReplayFrame(double time, double delta, 
			Map<Integer, ReplayActorUpdate> actorUpdatesById) {
		this.time = time;
		this.delta = delta;
		this.actorUpdatesById = actorUpdatesById;
	}
	

}
