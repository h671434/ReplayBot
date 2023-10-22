package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LoadoutsOnline {
    private final List<List<Product>> blue;
    private final List<List<Product>> orange;
    private final boolean unknown1;
    private final boolean unknown2;

    @JsonCreator
    public LoadoutsOnline(
    		@JsonProperty("blue") List<List<Product>> blue,
    		@JsonProperty("orange") List<List<Product>> orange,
    		@JsonProperty("unknown1") boolean unknown1,
    		@JsonProperty("unknown2") boolean unknown2) {
        this.blue = blue;
        this.orange = orange;
        this.unknown1 = unknown1;
        this.unknown2 = unknown2;
    }

    public List<List<Product>> getBlue() {
        return blue;
    }

    public List<List<Product>> getOrange() {
        return orange;
    }

    public boolean isUnknown1() {
        return unknown1;
    }

    public boolean isUnknown2() {
        return unknown2;
    }
}
