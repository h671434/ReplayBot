package replaybot.math;

public class Matrix3x3 implements Rotation {

	private Vector3 forward;
	private Vector3 right;
	private Vector3 up;
	
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
		return this;
	}

}
