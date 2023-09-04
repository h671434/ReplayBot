package replaybot.math;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vector3 {

	@JsonProperty("x")
	public final double x;
	
	@JsonProperty("y")
	public final double y;
	
	@JsonProperty("z")
	public final double z;
	
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3(rlbot.flat.Vector3 vec) {
		this.x = vec.x();
		this.y = vec.y();
		this.z = vec.z();
	}
	
	public Vector3(rlbot.flat.Rotator rot) {
		this.x = rot.pitch();
		this.y = rot.yaw();
		this.z = rot.roll();
	}
	
}
