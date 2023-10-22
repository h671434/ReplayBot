package replaybot.data.replay.remoteid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayStationId {
	
    private final long onlineId;
    private final String name;
    private final byte[] unknown1;

    @JsonCreator
    public PlayStationId(
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
