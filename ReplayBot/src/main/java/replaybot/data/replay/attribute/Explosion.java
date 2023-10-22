package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Vector3;

public class Explosion {
	
    private final boolean flag;
    private final int actor;
    private final Vector3 location;

    @JsonCreator
    public Explosion(
    		@JsonProperty("flag") boolean flag,
    		@JsonProperty("actor") int actor,
    		@JsonProperty("location") Vector3 location) {
        this.flag = flag;
        this.actor = actor;
        this.location = location;
    }

    public boolean isFlag() {
        return flag;
    }

    public int getActor() {
        return actor;
    }

    public Vector3 getLocation() {
        return location;
    }
    
}