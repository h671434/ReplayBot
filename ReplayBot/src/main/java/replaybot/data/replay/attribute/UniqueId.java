package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.data.replay.remoteid.RemoteId;

public class UniqueId {
	
    private final int systemId;
    private final RemoteId remoteId;
    private final int localId;

    @JsonCreator
    public UniqueId(
    		@JsonProperty("system_id") int systemId,
    		@JsonProperty("remote_id") RemoteId remoteId,
    		@JsonProperty("local_id") int localId) {
        this.systemId = systemId;
        this.remoteId = remoteId;
        this.localId = localId;
    }

    public int getSystemId() {
        return systemId;
    }

    public RemoteId getRemoteId() {
        return remoteId;
    }

    public int getLocalId() {
        return localId;
    }
}
