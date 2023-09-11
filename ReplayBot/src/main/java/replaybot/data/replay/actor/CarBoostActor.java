package replaybot.data.replay.actor;

public class CarBoostActor extends CarComponentActor {

	private int boostAmount;
	
	public CarBoostActor(int id) {
		super(id);
	}
	
	public int getBoostAmount() {
		return boostAmount;
	}
	
	@Override
	public void updateProperty(ActorUpdateProperty<?> property) {
		if("TAGame.CarComponent_Boost_TA:ReplicatedBoostAmount".equals(property.getName()) && property.isInt()) {
			boostAmount = property.getInt();
		} else {
			super.updateProperty(property);
		}
	}

}
