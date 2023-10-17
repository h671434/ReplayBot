package replaybot.math;

import java.util.List;

public class Vector3 extends Vector implements Rotation {

	private final double x;
	private final double y;
	private final double z;
	
	public Vector3(double x, double y, double z) {
		super(List.of(x, y, z));
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3(rlbot.flat.Vector3 vec) {
		this(vec.x(), vec.y(), vec.z());
	}
	
	public Vector3(rlbot.flat.Rotator rot) {
		this(rot.pitch(), rot.yaw(), rot.roll());
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
		// TODO Auto-generated method stub
		return null;
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
