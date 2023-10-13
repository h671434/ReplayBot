package replaybot.replay.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("compressed_word_vector")
public record CompressedWordVector3(
		@JsonProperty("x")
		CompressedWord x,
		@JsonProperty("y")
		CompressedWord y,
		@JsonProperty("z")
		CompressedWord z) implements Rotation {

}
