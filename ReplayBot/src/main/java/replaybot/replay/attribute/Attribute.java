package replaybot.replay.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.replay.property.CompressedWord;

public record Attribute<T>(
		@JsonProperty("id")
		CompressedWord id, 
		@JsonProperty("name")
		String name, 
		@JsonProperty("value")
		T value)  {

}
