package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CamSettings {

	private final float fov;
	private final float height;
	private final float angle;
	private final float distance;
	private final float stiffness;
	private final float swivel;
	private final float transition;
	
	@JsonCreator
	public CamSettings(
			@JsonProperty("fov") float fov, 
			@JsonProperty("height") float height,
			@JsonProperty("angle") float angle, 
			@JsonProperty("distance") float distance, 
			@JsonProperty("stiffness") float stiffness,
			@JsonProperty("swivel") float swivel,
			@JsonProperty("transition") float transition) {
		this.fov = fov;
		this.height = height;
		this.angle = angle;
		this.distance = distance;
		this.stiffness = stiffness;
		this.swivel = swivel;
		this.transition = transition;
	}

	public float getFov() {
		return fov;
	}

	public float getHeight() {
		return height;
	}

	public float getAngle() {
		return angle;
	}

	public float getDistance() {
		return distance;
	}

	public float getStiffness() {
		return stiffness;
	}

	public float getSwivel() {
		return swivel;
	}

	public float getTransition() {
		return transition;
	}
	
}
