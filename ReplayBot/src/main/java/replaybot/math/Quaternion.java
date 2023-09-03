package replaybot.math;

public class Quaternion extends Vector3 {

	public final double w;
	
	public Quaternion(double w, double x, double y, double z) {
		super(x, y, z);
		this.w = w;
	}

}
