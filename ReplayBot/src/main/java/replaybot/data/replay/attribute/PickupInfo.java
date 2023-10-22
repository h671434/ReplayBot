package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PickupInfo {
    private final boolean active;
    private final int actor;
    private final boolean itemsArePreview;
    private final boolean unknown;
    private final boolean unknown2;

    @JsonCreator
    public PickupInfo(
    		@JsonProperty("active") boolean active,
    		@JsonProperty("actor") int actor,
    		@JsonProperty("items_are_preview") boolean itemsArePreview,
    		@JsonProperty("unknown") boolean unknown,
    		@JsonProperty("unknown2") boolean unknown2) {
        this.active = active;
        this.actor = actor;
        this.itemsArePreview = itemsArePreview;
        this.unknown = unknown;
        this.unknown2 = unknown2;
    }

    public boolean isActive() {
        return active;
    }

    public int getActor() {
        return actor;
    }

    public boolean areItemsPreview() {
        return itemsArePreview;
    }

    public boolean isUnknown() {
        return unknown;
    }

    public boolean isUnknown2() {
        return unknown2;
    }
}

