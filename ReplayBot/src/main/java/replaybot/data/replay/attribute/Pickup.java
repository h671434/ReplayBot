package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;

public class Pickup {
	
    private final int instigator;
    private final boolean pickedUp;

    @JsonCreator
    public Pickup(
    		@JsonProperty("instigator") int instigator,
    		@JsonProperty("picked_up") boolean pickedUp) {
        this.instigator = instigator;
        this.pickedUp = pickedUp;
    }

    public int getInstigator() {
        return instigator;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }
}

