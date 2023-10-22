package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtendedExplosion {
	
    private final Explosion explosion;
    private final boolean unknown1;
    private final int secondaryActor;

    @JsonCreator
    public ExtendedExplosion(
    		@JsonProperty("explosion") Explosion explosion,
    		@JsonProperty("unknown1") boolean unknown1,
    		@JsonProperty("secondary_actor") int secondaryActor) {
        this.explosion = explosion;
        this.unknown1 = unknown1;
        this.secondaryActor = secondaryActor;
    }

    public Explosion getExplosion() {
        return explosion;
    }

    public boolean isUnknown1() {
        return unknown1;
    }

    public int getSecondaryActor() {
        return secondaryActor;
    }
    
}
