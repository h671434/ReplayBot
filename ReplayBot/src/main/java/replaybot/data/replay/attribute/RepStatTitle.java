package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RepStatTitle {
	
    private final boolean unknown;
    private final String name;
    private final boolean unknown2;
    private final int index;
    private final int value;

    @JsonCreator
    public RepStatTitle(
    		@JsonProperty("unknown") boolean unknown,
    		@JsonProperty("name") String name,
    		@JsonProperty("unknown2") boolean unknown2,
    		@JsonProperty("index") int index,
    		@JsonProperty("value") int value) {
        this.unknown = unknown;
        this.name = name;
        this.unknown2 = unknown2;
        this.index = index;
        this.value = value;
    }

    public boolean isUnknown() {
        return unknown;
    }

    public String getName() {
        return name;
    }

    public boolean isUnknown2() {
        return unknown2;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}

