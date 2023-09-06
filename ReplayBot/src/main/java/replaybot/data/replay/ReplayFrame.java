package replaybot.data.replay;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.replay.actor.ActorUpdate;

public class ReplayFrame {
	
	public final double time;
	public final double delta;
	public final List<Integer> deletedActorIds;
	public final List<ActorUpdate> updatedActors;
	
	public ReplayFrame(double time, double delta, List<Integer> deletedActorIds, List<ActorUpdate> updatedActors) {
		this.time = time;
		this.delta = delta;
		this.deletedActorIds = Collections.unmodifiableList(deletedActorIds);
		this.updatedActors = Collections.unmodifiableList(updatedActors);
	}

}
