package replaybot.replay.attribute;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CameraSettings {
	
	@JsonProperty("fov")
	private int fov;
	
	@JsonProperty("height")
	private int height;
	
	@JsonProperty("pitch")
	private int pitch;
	
	@JsonProperty("distance")
	private int distance;
	
	@JsonProperty("stiffness")
	private float stiffness;
	
	@JsonProperty("swivel_speed")
	private float swivelSpeed;
	
	@JsonProperty("transitionSpeed")
	private float transitionSpeed;

	public CameraSettings(int fov, int height, int pitch, int distance, float stiffness, float swivelSpeed,
			float transitionSpeed) {
		this.fov = fov;
		this.height = height;
		this.pitch = pitch;
		this.distance = distance;
		this.stiffness = stiffness;
		this.swivelSpeed = swivelSpeed;
		this.transitionSpeed = transitionSpeed;
	}

	public int getFov() {
		return fov;
	}

	public int getHeight() {
		return height;
	}

	public int getPitch() {
		return pitch;
	}

	public int getDistance() {
		return distance;
	}

	public float getStiffness() {
		return stiffness;
	}

	public float getSwivelSpeed() {
		return swivelSpeed;
	}

	public float getTransitionSpeed() {
		return transitionSpeed;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance, fov, height, pitch, stiffness, swivelSpeed, transitionSpeed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		CameraSettings other = (CameraSettings) obj;
		
		return distance == other.distance && fov == other.fov && height == other.height && pitch == other.pitch
				&& Float.floatToIntBits(stiffness) == Float.floatToIntBits(other.stiffness)
				&& Float.floatToIntBits(swivelSpeed) == Float.floatToIntBits(other.swivelSpeed)
				&& Float.floatToIntBits(transitionSpeed) == Float.floatToIntBits(other.transitionSpeed);
	}

	@Override
	public String toString() {
		return "CameraSettings [fov=" + fov + ", height=" + height + ", pitch=" + pitch + ", distance=" + distance
				+ ", stiffness=" + stiffness + ", swivelSpeed=" + swivelSpeed + ", transitionSpeed=" + transitionSpeed
				+ "]";
	}
	
}
