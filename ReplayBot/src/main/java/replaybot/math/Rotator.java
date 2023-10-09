package replaybot.math;

public class Rotator extends Vector3 {

	public final double w;
	
	public Rotator(double x, double y, double z, double w) {
		super(x, y, z);
		this.w = w;
	}

}
