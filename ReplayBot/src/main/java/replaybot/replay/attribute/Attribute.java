package replaybot.replay.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

import replaybot.replay.property.CompressedWord;
import replaybot.replay.storage.AttributeDeserializer;

@JsonDeserialize(using = AttributeDeserializer.class)
public record Attribute<T>(
		@JsonProperty("id")
		CompressedWord id, 
		@JsonProperty("name")
		String name, 
		@JsonProperty("value")
		@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
		T value)  {
	
}
