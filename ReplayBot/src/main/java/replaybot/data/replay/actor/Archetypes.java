package replaybot.data.replay.actor;

public class Archetypes {

	public static BallTA defaultBall() {
		return new BallTA();
	}
	
	public static CarTA defaultCar() {
		return new CarTA();
	}
	
	public static CarComponentBoostTA carComponentBoost() {
		return new CarComponentBoostTA();
	}
	
	public static CarComponentFlipCarTA carComponentFlipCar() {
		return new CarComponentFlipCarTA();
	}
	
	public static CarComponentDodgeTA carComponentDodge() {
		return new CarComponentDodgeTA();
	}
	
	public static CarComponentJumpTA carComponentJump() {
		return new CarComponentJumpTA();
	}
	
	public static CarComponentDoubleJumpTA carComponentDoubleJump() {
		return new CarComponentDoubleJumpTA();
	}
	
	
}
