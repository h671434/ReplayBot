package replaybot.math;

public class Vector3 {
	
	public static final Vector3 ZERO = new Vector3(0, 0, 0);

	private final double x;
	private final double y;
	private final double z;
	
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3(rlbot.flat.Vector3 vec) {
		this(vec.x(), vec.y(), vec.z());
	}
	
	public Vector3(Vector3 other) {
		this(other.x, other.y, other.z);
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public double z() {
		return z;
	}

}
