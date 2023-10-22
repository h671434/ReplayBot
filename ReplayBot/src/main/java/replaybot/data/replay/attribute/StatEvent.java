package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatEvent {
    private boolean unknown1;
    private int objectId;

    @JsonCreator
    public StatEvent(
    		@JsonProperty("unknown1") boolean unknown1, 
    		@JsonProperty("object_id") int objectId) {
        this.unknown1 = unknown1;
        this.objectId = objectId;
    }

    public boolean isUnknown1() {
        return unknown1;
    }

    public int getObjectId() {
        return objectId;
    }
}

