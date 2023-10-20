package replaybot.data.actor;

public abstract class Actor implements Cloneable {

	private final int actorId;
	
	public Actor(int actorId) {
		this.actorId = actorId;
	}
	
	public int getActorId() {
		return actorId;
	}
	
	@Override
	public abstract Actor clone();
	
}
