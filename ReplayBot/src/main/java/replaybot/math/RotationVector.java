package replaybot.math;

import rlbot.flat.Rotator;

public class RotationVector extends Vector3 implements Rotation {
	
	public RotationVector(double pitch, double yaw, double roll) {
		super(pitch, yaw, roll);
	}
	
	public RotationVector(Rotator rot) {
		this(rot.pitch(), rot.yaw(), rot.roll());
	}
	
	public double pitch() {
		return x();
	}
	
	public double yaw() {
		return y();
	}
	
	public double roll() {
		return z();
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
