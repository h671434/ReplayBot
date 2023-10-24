package replaybot.math;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Vector3 implements Rotation {
	
	public static final Vector3 ZERO = new Vector3(0, 0, 0);

	private final double x;
	private final double y;
	private final double z;
	
	@JsonCreator
	public Vector3(
			@JsonProperty("x") @JsonAlias("pitch") double x, 
			@JsonProperty("y") @JsonAlias("roll") double y,
			@JsonProperty("z") @JsonAlias("yaw") double z) {
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

	@Override
	public Vector3 asEulerAngles() {
		return this;
	}

	@Override
	public Quaternion asQuaternion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix3x3 asRotationMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

}
