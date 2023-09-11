package replaybot.data.replay.actor;

public abstract class CarComponentActor extends Actor {
	
	private ActorUpdateProperties.ActiveActor vehicle;
	
	public CarComponentActor(int id) {
		super(id);
	}
	
	@Override
	public void updateProperty(ActorUpdateProperty<?> property) {
		if("TAGame.CarComponent_TA:Vehicle".equals(property.getName()) && property.isActiveActor()) {
			vehicle = property.getActiveActor();
		}
	}

}
