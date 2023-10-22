package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PickupNew {
	
    private final int instigator;
    private final int pickedUp;

    @JsonCreator
    public PickupNew(
    		@JsonProperty("instigator") int instigator, 
    		@JsonProperty("picked_up") int pickedUp) {
        this.instigator = instigator;
        this.pickedUp = pickedUp;
    }

    public int getInstigator() {
        return instigator;
    }

    public int getPickedUp() {
        return pickedUp;
    }
}