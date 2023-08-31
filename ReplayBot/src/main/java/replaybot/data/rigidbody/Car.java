package replaybot.data.rigidbody;

public class Car extends RigidBody {

	public final int id;
	public final int team;
	public final int boost;
	public final boolean jumped;
	public final boolean doubleJumped;
	public final boolean hasWheelContact;
	public final boolean isDemolished;
	
	public Car(rlbot.flat.PlayerInfo player) {
		super(player.physics());
		this.id = player.spawnId();
		this.team = player.team();
		this.boost = player.boost();
		this.jumped = player.jumped();
		this.doubleJumped = player.doubleJumped();
		this.hasWheelContact = player.hasWheelContact();
		this.isDemolished = player.isDemolished();
	}
	
}
