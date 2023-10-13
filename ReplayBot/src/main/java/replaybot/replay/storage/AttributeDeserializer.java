package replaybot.replay.storage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.replay.ReplayFrame;
import replaybot.replay.attribute.Attribute;
import replaybot.replay.attribute.FlaggedInt;
import replaybot.replay.attribute.ReplicatedRBState;
import replaybot.replay.property.CompressedWord;
import replaybot.replay.replication.Replication;

public class AttributeDeserializer extends StdDeserializer<Attribute<?>> {
	
	public AttributeDeserializer() {
		super(Attribute.class);
	}

	@Override
	public Attribute<?> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		CompressedWord id = null;
		String name = null;
		Attribute<?> updated = null;
		
		JsonToken currentToken = jp.getCurrentToken();
		
		if(currentToken != JsonToken.START_OBJECT) {
			currentToken = jp.nextToken();
		}
		
		for(; currentToken != JsonToken.END_OBJECT; currentToken = jp.nextToken()) {
			if(currentToken == JsonToken.START_OBJECT && "id".equals(jp.getCurrentName())) {
				id = jp.readValueAs(CompressedWord.class);
			} else if(currentToken == JsonToken.VALUE_STRING && "name".equals(jp.getCurrentName())) {
				name = jp.getText();
			} else if("value".equals(jp.getCurrentName())) {
				updated = resolveValueAndDeserialize(jp, id, name);
			}
		}
		
		return updated;
	}
	
	public Attribute<?> resolveValueAndDeserialize(JsonParser jp, CompressedWord id, String name) throws JsonParseException, IOException {
		if(jp.getCurrentToken() != JsonToken.START_OBJECT) {
			jp.nextToken();
		}
		
		jp.nextValue();
		
		String fieldname = jp.getCurrentName();
		
		if(AttributeClassMap.contains(fieldname)) {
			Class<?> attributeClass = AttributeClassMap.get(fieldname);
			
			return new Attribute<>(id, name, jp.readValueAs(attributeClass));
		}
		
		return new Attribute<>(id, name, null);
	}
	

}
