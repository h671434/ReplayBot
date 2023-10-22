package replaybot.data.replay.replication;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class ReplicationUpdated extends Replication {
	
	private List<UpdatedAttribute> attributes;

	public ReplicationUpdated(int actorId, List<UpdatedAttribute> attributes) {
		super(actorId);
		this.attributes = attributes;
	}

}
