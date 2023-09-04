package replaybot.data.replay;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.replay.replication.Replication;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplayFrame {
	
	@JsonProperty("time")
	private final double time;
	
	@JsonProperty("delta")
	private final double delta;
	
	@JsonProperty("replications")
	private final List<Replication> replications;
	
	public ReplayFrame() {
		this(0, 0, null);
	}
	
	public ReplayFrame(double time, double delta, List<Replication> updatedActors) {
		this.time = time;
		this.delta = delta;
		this.replications = updatedActors;
	}
	
	public double getTime() {
		return time;
	}
	
	public double getDelta() {
		return delta;
	}
	
	public Replication getReplication(int index) {
		return replications.get(index);
	}

}
