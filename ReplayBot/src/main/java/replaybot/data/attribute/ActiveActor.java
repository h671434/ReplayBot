package replaybot.data.attribute;

public class ActiveActor {

	private final boolean active;
	private final int actorId;
	
	public ActiveActor(boolean active, int actorId) {
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
