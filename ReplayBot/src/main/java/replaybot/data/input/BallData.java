package replaybot.data.input;

import rlbot.flat.Touch;

public class BallData extends RigidBodyState {
	
	public final double latestTouch;
	
	public BallData(rlbot.flat.BallInfo ball) {
		super(ball.physics());
		this.latestTouch = ball.latestTouch().gameSeconds();
	}

}
