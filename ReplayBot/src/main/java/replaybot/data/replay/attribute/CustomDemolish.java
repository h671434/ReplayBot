package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Vector3;

public class CustomDemolish {
	
    private final boolean customDemoFlag;
    private final int customDemoId;
    private final Demolish demolish;

    @JsonCreator
    public CustomDemolish(
    		@JsonProperty("custom_demo_flag") boolean customDemoFlag,
    		@JsonProperty("custom_demo_id") int customDemoId,
    		@JsonProperty("demolish") Demolish demolish) {
        this.customDemoFlag = customDemoFlag;
        this.customDemoId = customDemoId;
        this.demolish = demolish;
    }

    public boolean isCustomDemoFlag() {
        return customDemoFlag;
    }

    public int getCustomDemoId() {
        return customDemoId;
    }

    public Demolish getDemolish() {
    	return demolish;
    }

}

