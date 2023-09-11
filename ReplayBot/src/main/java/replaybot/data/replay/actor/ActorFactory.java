package replaybot.data.replay.actor;

public class ActorFactory {

	public static Actor createActor(ActorUpdate ofTypeNew) {
		if(!ofTypeNew.isNew()) {
			throw new IllegalArgumentException("ActorUpdate is not of type New");
		}
		
		switch(ofTypeNew.getClassName()) {
		case "TAGame.Car_TA":
			return createCarActor(ofTypeNew);
		case "TAGame.Ball_TA":
			return createBallActor(ofTypeNew);
		case "TAGame.CarComponent_Boost_TA":
			return createCarBoostActor(ofTypeNew);
		case "TAGame.CarComponent_Dodge_TA":
			return createCarDodgeActor(ofTypeNew);
		case "CarComponent_Jump_TA":
			return createCarJumpActor(ofTypeNew);
		case "TAGame.CarComponent_DoubleJump_TA":
			return createCarDoubleJumpActor(ofTypeNew);
		case "TAGame.CarComponent_FlipCar_TA":
			return createCarFlipActor(ofTypeNew);
		case "TAGame.VehiclePickup_Boost_TA":
			return createVehiclePickupBoostActor(ofTypeNew);
		}
		
		return null;
	}
	
	public static CarActor createCarActor(ActorUpdate ofTypeNew) {
		return new CarActor(ofTypeNew.getActorId());
	}
	
	public static BallActor createBallActor(ActorUpdate ofTypeNew) {
		return new BallActor(ofTypeNew.getActorId());
	}
	
	public static CarBoostActor createCarBoostActor(ActorUpdate ofTypeNew) {
		return new CarBoostActor(ofTypeNew.getActorId());
	}

	public static CarDodgeActor createCarDodgeActor(ActorUpdate ofTypeNew) {
		return new CarDodgeActor(ofTypeNew.getActorId());
	}
	
	public static CarJumpActor createCarJumpActor(ActorUpdate ofTypeNew) {
		return new CarJumpActor(ofTypeNew.getActorId());
	}
	
	public static CarDoubleJumpActor createCarDoubleJumpActor(ActorUpdate ofTypeNew) {
		return new CarDoubleJumpActor(ofTypeNew.getActorId());
	}
	
	public static CarFlipActor createCarFlipActor(ActorUpdate ofTypeNew) {
		return new CarFlipActor(ofTypeNew.getActorId());
	}
	
	public static VehiclePickupBoostActor createVehiclePickupBoostActor(ActorUpdate ofTypeNew) {
		return new VehiclePickupBoostActor(ofTypeNew.getActorId());
	}
	
}
