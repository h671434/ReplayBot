package replaybot.data.replay.attribute;

public class ActiveActor {

	private boolean active;
	private int actorId;
	
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
