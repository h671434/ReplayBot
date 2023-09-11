package replaybot.data.replay.actor;

import replaybot.math.Vector3;

public class CarDodgeActor extends CarComponentActor {

	private Vector3 dodgeTorque;
	
	public CarDodgeActor(int id) {
		super(id);
	}
	
	@Override
	public void updateProperty(ActorUpdateProperty<?> property) {
		if("TAGame.CarComponent_Dodge_TA:DodgeTorque".equals(property.getName()) && property.isVector3()) {
			dodgeTorque = property.getVector3();
		}
	}
	
	public Vector3 getTorque() {
		return dodgeTorque;
	}

}
