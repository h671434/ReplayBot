package replaybot.replay.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.replay.Replay;
import replaybot.replay.ReplayFrame;
import replaybot.replay.property.CompressedWord;

public class ReplayDeserializer extends StdDeserializer<Replay> {

	protected ReplayDeserializer() {
		super(Replay.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Replay deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		List<ReplayFrame> frames = null;
		
		JsonToken currentToken = jp.getCurrentToken();
		
		if(currentToken != JsonToken.START_OBJECT) {
			currentToken = jp.nextToken();
		}
		
		for(; currentToken != JsonToken.END_OBJECT; currentToken = jp.nextToken()) {
			String fieldName = jp.getCurrentName();
			
			if(fieldName == null) {
				continue;
			}
			switch(fieldName) {
			case "content":
			case "header":
			case "body":
				// Ignore to iterate over children
				break;
			case "frames":
				frames = deserializeFrames(jp);
				break;
			default: 
				jp.skipChildren();
			}
		}
			
		return new Replay(frames);
	}
	
	public List<ReplayFrame> deserializeFrames(JsonParser jp) throws JsonParseException, IOException {
		if(jp.getCurrentToken() != JsonToken.START_ARRAY) {
			jp.nextToken();
		}
		
		List<ReplayFrame> frames = new ArrayList<>();
		
		//jp.readValuesAs(ReplayFrame.class).forEachRemaining(frames::add);
		
		JsonToken currentToken = jp.getCurrentToken();
		
		for(; currentToken != JsonToken.END_ARRAY; currentToken = jp.nextToken()) {
			if(currentToken == JsonToken.START_OBJECT) {
				frames.add(jp.readValueAs(ReplayFrame.class));
			}	
		}
		
		return frames;
	}

}
