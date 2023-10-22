package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ps4Id {
	
    private final long onlineId;
    private final String name;
    private final byte[] unknown1;

    @JsonCreator
    public Ps4Id(
    		@JsonProperty("online_id") long onlineId, 
    		@JsonProperty("name") String name, 
    		@JsonProperty("unknown1") byte[] unknown1) {
        this.onlineId = onlineId;
        this.name = name;
        this.unknown1 = unknown1;
    }

    public long getOnlineId() {
        return onlineId;
    }

    public String getName() {
        return name;
    }

    public byte[] getUnknown1() {
        return unknown1;
    }
}
