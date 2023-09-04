package replaybot.data.replay.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.data.replay.Replay;
import replaybot.data.replay.ReplayFrame;
import replaybot.data.replay.ReplayProperties;

public class ReplayDeserializer extends StdDeserializer<Replay> {
	
	public ReplayDeserializer() {
		super(Replay.class);
	}

	@Override
	public Replay deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {
		JsonToken current = jp.getCurrentToken();
		
		if(current != JsonToken.START_OBJECT) {
			current = jp.nextToken();
		}
		
		ReplayProperties properties = null;
		List<ReplayFrame> frames = null;
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			if(current == JsonToken.START_OBJECT && "header".equals(jp.getCurrentName())) {
				properties = deserializeHeader(jp);
			}
			if(current == JsonToken.START_OBJECT && "content".equals(jp.getCurrentName())) {
				frames = deserializeContent(jp);
			}
		}
		
		return new Replay(properties, frames);
	}
	
	private ReplayProperties deserializeHeader(JsonParser jp) {
		return null; //TODO
	}
	
	private List<ReplayFrame> deserializeContent(JsonParser jp) throws JsonParseException, IOException {
		JsonToken current = jp.getCurrentToken();
		
		if(current != JsonToken.START_OBJECT) {
			current = jp.nextToken();
		}
		
		List<ReplayFrame> frames = null;
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			if(current == JsonToken.START_OBJECT && "body".equals(jp.getCurrentName())) {
				frames = deserializeContentBody(jp);
			}
		}
		
		return frames;
	}
	
	private List<ReplayFrame> deserializeContentBody(JsonParser jp) throws JsonParseException, IOException {
		JsonToken current = jp.getCurrentToken();
		
		if("body".equals(jp.getCurrentName())) {
			current = jp.nextToken();
		}
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			System.out.println(jp.getCurrentName());
			if(current == JsonToken.START_ARRAY && "frames".equals(jp.getCurrentName())) {
				return deserializeFrames(jp);
			}
			
			if(current == JsonToken.START_ARRAY || current == JsonToken.START_OBJECT) {
				jp.skipChildren();
			}
		}
		
		return null;
	}
	
	private List<ReplayFrame> deserializeFrames(JsonParser jp) throws JsonParseException, IOException {
		JsonToken current = jp.getCurrentToken();
		
		if(current != JsonToken.START_ARRAY) {
			current = jp.nextToken();
		}
		
		List<ReplayFrame> frames = new ArrayList<>();
		
		for(; current != JsonToken.END_ARRAY; current = jp.nextToken()) {
			if(current == JsonToken.START_OBJECT) {
				frames.add(jp.readValueAs(ReplayFrame.class));
			}
		}
		
		return frames;
	}
	

}
