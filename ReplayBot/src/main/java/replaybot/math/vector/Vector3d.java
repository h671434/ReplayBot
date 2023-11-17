package replaybot.math.vector;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Vector3d {
	
	public static final Vector3d ZERO = new Vector3d(0, 0, 0);

	private final double x;
	private final double y;
	private final double z;
	
	public Vector3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3d(rlbot.flat.Vector3 vec) {
		this(vec.x(), vec.y(), vec.z());
	}
	
	public Vector3d(Vector3d other) {
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
