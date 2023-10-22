package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {
	
    private final int number;
    private final UniqueId uniqueId;
    private final String name;
    private final boolean unknown1;
    private final boolean unknown2;
    private final Integer unknown3;

    @JsonCreator
    public Reservation(
    		@JsonProperty("number") int number,
    		@JsonProperty("unique_id") UniqueId uniqueId,
    		@JsonProperty("name") String name,
    		@JsonProperty("unknown1") boolean unknown1,
    		@JsonProperty("unknown2") boolean unknown2,
    		@JsonProperty("unknown3") Integer unknown3) {
        this.number = number;
        this.uniqueId = uniqueId;
        this.name = name;
        this.unknown1 = unknown1;
        this.unknown2 = unknown2;
        this.unknown3 = unknown3;
    }

    public int getNumber() {
        return number;
    }

    public UniqueId getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public boolean isUnknown1() {
        return unknown1;
    }

    public boolean isUnknown2() {
        return unknown2;
    }

    public Integer getUnknown3() {
        return unknown3;
    }
}
