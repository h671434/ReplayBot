package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamLoadout {
	
    private final Loadout blue;
    private final Loadout orange;

    @JsonCreator
    public TeamLoadout(
    		@JsonProperty("blue") Loadout blue, 
    		@JsonProperty("orange") Loadout orange) {
        this.blue = blue;
        this.orange = orange;
    }

    public Loadout getBlue() {
        return blue;
    }

    public Loadout getOrange() {
        return orange;
    }
}

