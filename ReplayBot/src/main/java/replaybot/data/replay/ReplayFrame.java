package replaybot.data.replay;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.data.replay.updatedactor.UpdatedActor;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplayFrame {
	
	static int i = 0;
	
	@JsonProperty("time")
	private final double time;
	
	@JsonProperty("delta")
	private final double delta;
	
	@JsonProperty("updated_actors")
	private final List<UpdatedActor> updatedActors;
	
	public ReplayFrame() {
		this(0, 0, null);
	}
	
	public ReplayFrame(double time, double delta, List<UpdatedActor> updatedActors) {
		this.time = time;
		this.delta = delta;
		this.updatedActors = updatedActors;
		System.out.println("f" + i);
	}
	
	public double getTime() {
		return time;
	}
	
	public double getDelta() {
		return delta;
	}
	
	public UpdatedActor getUpdatedActor(int index) {
		return updatedActors.get(index);
	}

}
