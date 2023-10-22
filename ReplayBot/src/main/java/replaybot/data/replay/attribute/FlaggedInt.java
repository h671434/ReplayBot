package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlaggedInt {

	private final boolean active;
	private final int actorId;
	
	@JsonCreator
	public FlaggedInt(
			@JsonProperty("active") boolean active,
			@JsonProperty("actor") int actorId) {
		this.active = active;
		this.actorId = actorId;
	}

	public boolean isActive() {
		return active;
	}

	public int getActorId() {
		return actorId;
	}
	
}
