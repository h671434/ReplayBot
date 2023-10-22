package replaybot.data.replay.attribute;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
    private final boolean unknown;
    private final int objectInd;
    private final ProductValue value;

    @JsonCreator
    public Product(
    		@JsonProperty("unknown") boolean unknown,
    		@JsonProperty("object_ind") int objectInd,
    		@JsonProperty("value") ProductValue value) {
        this.unknown = unknown;
        this.objectInd = objectInd;
        this.value = value;
    }

    public boolean isUnknown() {
        return unknown;
    }

    public int getObjectInd() {
        return objectInd;
    }

    public ProductValue getValue() {
        return value;
    }
}
