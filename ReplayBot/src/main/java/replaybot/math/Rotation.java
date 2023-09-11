package replaybot.math;

public class Rotation extends Vector3 {

	public final double w;
	
	public Rotation(double x, double y, double z, double w) {
		super(x, y, z);
		this.w = w;
	}

}
