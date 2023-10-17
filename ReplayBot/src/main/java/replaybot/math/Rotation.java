package replaybot.math;

public interface Rotation {

	Vector3 asEulerAngles();
	
	Quaternion asQuaternion();
	
	Matrix3x3 asRotationMatrix();
	

}
