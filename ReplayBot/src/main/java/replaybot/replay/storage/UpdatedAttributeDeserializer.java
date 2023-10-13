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

import replaybot.replay.Frame;
import replaybot.replay.attribute.FlaggedInt;
import replaybot.replay.attribute.ReplicatedRBState;
import replaybot.replay.property.CompressedWord;
import replaybot.replay.replication.Replication;
import replaybot.replay.replication.UpdatedAttribute;

public class UpdatedAttributeDeserializer extends StdDeserializer<UpdatedAttribute<?>> {

	private static final Map<String, Class<?>> ATTRIBUTE_CLASS_BY_NAME = 
			Map.ofEntries(
			Map.entry("byte", Byte.class),
			Map.entry("boolean", Boolean.class),
			Map.entry("int", Integer.class),
			Map.entry("float", Float.class),
			Map.entry("string", String.class),
			Map.entry("flagged_int", FlaggedInt.class),
			Map.entry("rigid_body_state", ReplicatedRBState.class));
	
	public UpdatedAttributeDeserializer() {
		super(UpdatedAttribute.class);
	}

	@Override
	public UpdatedAttribute<?> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		CompressedWord id = null;
		String name = null;
		UpdatedAttribute<?> updated = null;
		
		JsonToken currentToken = jp.getCurrentToken();
		
		if(currentToken != JsonToken.START_OBJECT) {
			currentToken = jp.nextToken();
		}
		
		for(; currentToken != JsonToken.END_OBJECT; currentToken = jp.nextToken()) {
			if("id".equals(jp.getCurrentName())) {
				id = jp.readValueAs(CompressedWord.class);
			} else if(currentToken == JsonToken.VALUE_STRING && "name".equals(jp.getCurrentName())) {
				name = jp.getText();
			} else if("value".equals(jp.getCurrentName())) {
				updated = resolveValueAndDeserialize(jp, id, name);
			}
		}
		
		return updated;
	}
	
	public UpdatedAttribute<?> resolveValueAndDeserialize(JsonParser jp, CompressedWord id, String name) throws JsonParseException, IOException {
		if(jp.getCurrentToken() != JsonToken.START_OBJECT) {
			jp.nextToken();
		}
		
		jp.nextValue();
		
		String fieldname = jp.getCurrentName();
		
		if(ATTRIBUTE_CLASS_BY_NAME.containsKey(fieldname)) {
			Class<?> attributeClass = ATTRIBUTE_CLASS_BY_NAME.get(fieldname);
			
			return new UpdatedAttribute<>(id, name, jp.readValueAs(attributeClass));
		}
		
		return new UpdatedAttribute<>(id, name, null);
	}
	

}
