package replaybot.data.replay.actor;

import java.util.List;

public abstract class Actor {

	private final int id;
	
	public Actor(int id) {
		this.id = id;
	}
	
	public void applyUpdate(ActorUpdate update) {
		if(!update.isUpdated()) {
			throw new IllegalArgumentException("ActorUpdate is not of type Updated");
		}
		
		update.getPropertyUpdates().forEach(this::updateProperty);
	}
	
	public abstract void updateProperty(ActorUpdateProperty<?> property);
	
	public int getId() {
		return id;
	}
	
}
