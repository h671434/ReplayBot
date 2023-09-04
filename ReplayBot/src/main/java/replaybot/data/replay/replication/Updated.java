package replaybot.data.replay.replication;

import java.util.List;

import replaybot.data.actor.update.ActorUpdate;

public class Updated extends Replication {
	
	private final List<ActorUpdate> attributes;
	
	public Updated(List<ActorUpdate> attributes) {
		this.attributes = attributes;
	}

}
