package replaybot.data.replay.remoteid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SwitchId {
	
    private final long onlineId;
    private final byte[] unknown1;

    @JsonCreator
    public SwitchId(
    		@JsonProperty("online_id") long onlineId, 
    		@JsonProperty("unknown1") byte[] unknown1) {
        this.onlineId = onlineId;
        this.unknown1 = unknown1;
    }

    public long getOnlineId() {
        return onlineId;
    }

    public byte[] getUnknown1() {
        return unknown1;
    }
}

