package replaybot.replay.property;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
      @JsonSubTypes.Type(value = Quaternion.class),
      @JsonSubTypes.Type(value = CompressedWordVector3.class)})
public interface Rotation {

}
