package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.data.replay.SpawnTrajectory;
import replaybot.math.Rotation;
import replaybot.math.Vector3;

public class RigidBody {
	
	private final boolean sleeping;
	private final Vector3 location;
	private final Rotation rotation;
	private final Vector3 linearVelocity;
	private final Vector3 angularVelocity;
	
	@JsonCreator
	public RigidBody(
			@JsonProperty("sleeping") boolean sleeping,
			@JsonProperty("location") Vector3 location,
			@JsonProperty("rotation") Rotation rotation,
			@JsonProperty("linear_velocity") Vector3 linearVelocity,
			@JsonProperty("angular_velocity") Vector3 angularVelocity) {
		this.sleeping = sleeping;
		this.location = location;
		this.rotation = rotation;
		this.linearVelocity = linearVelocity;
		this.angularVelocity = angularVelocity;
	}

	public boolean isSleeping() {
		return sleeping;
	}
	
	public Vector3 getLocation() {
		return location;
	}

	public Rotation getRotation() {
		return rotation;
	}

	public Vector3 getLinearVelocity() {
		return linearVelocity;
	}

	public Vector3 getAngularVelocity() {
		return angularVelocity;
	}
	
}
