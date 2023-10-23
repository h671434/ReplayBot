package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Rotation;
import replaybot.math.Vector3;

public class Welded {
	
    private final boolean active;
    private final int actor;
    private final Vector3 offset;
    private final float mass;
    private final Rotation rotation;

    @JsonCreator
    public Welded(
    		@JsonProperty("active") boolean active,
    		@JsonProperty("actor") int actor,
    		@JsonProperty("offset") Vector3 offset,
    		@JsonProperty("mass") float mass,
    		@JsonProperty("rotation") Rotation rotation) {
        this.active = active;
        this.actor = actor;
        this.offset = offset;
        this.mass = mass;
        this.rotation = rotation;
    }

    public boolean isActive() {
        return active;
    }

    public int getActor() {
        return actor;
    }

    public Vector3 getOffset() {
        return offset;
    }

    public float getMass() {
        return mass;
    }

    public Rotation getRotation() {
        return rotation;
    }
}
