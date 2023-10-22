package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Impulse {
	
    private final int compressedRotation;
    private final float speed;

    @JsonCreator
    public Impulse(
    		@JsonProperty("compressed_rotation") int compressedRotation,
    		@JsonProperty("speed") float speed) {
        this.compressedRotation = compressedRotation;
        this.speed = speed;
    }

    public int getCompressedRotation() {
        return compressedRotation;
    }

    public float getSpeed() {
        return speed;
    }
}

