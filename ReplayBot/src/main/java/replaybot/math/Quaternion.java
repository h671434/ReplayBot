package replaybot.math;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Quaternion implements Rotation {
	
	private final Vector3 vector;
	private final double w;	
	
	@JsonCreator
	public Quaternion(
			@JsonProperty("x") double x, 
			@JsonProperty("y") double y,
			@JsonProperty("z") double z,
			@JsonProperty("w") double w) {
		this.vector = new Vector3(x, y, z);
		this.w = w;
	}
	
	public double w() {
		return w;
	}
	
	public double x() {
		return vector.x();
	}
	
	public double y() {
		return vector.y();
	}
	
	public double z() {
		return z();
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
