package replaybot.data;

import rlbot.flat.Touch;

public class Ball {
	
	public final double latestTouch;
	public final RigidBody physics;
	
	public Ball(rlbot.flat.BallInfo ball) {
		this.latestTouch = ball.latestTouch().gameSeconds();
		this.physics = new RigidBody(ball.physics());
	}

}
