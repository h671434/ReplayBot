package replaybot.data.input;

import replaybot.data.attribute.RigidBody;
import rlbot.flat.Touch;

public class Ball extends RigidBody {
	
	public final double latestTouch;
	
	public Ball(rlbot.flat.BallInfo ball) {
		super(ball.physics());
		this.latestTouch = ball.latestTouch().gameSeconds();
	}

}
