package replaybot.data.actor;

import replaybot.data.attribute.RigidBody;
import rlbot.flat.Touch;

public class Ball extends Actor {
	
	public final double latestTouch;
	public final RigidBody physics;
	
	public Ball(rlbot.flat.BallInfo ball) {
		super(-1);
		this.latestTouch = ball.latestTouch().gameSeconds();
		this.physics = new RigidBody(ball.physics());
	}

}
