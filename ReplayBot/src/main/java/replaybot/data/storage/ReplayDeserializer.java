package replaybot.data.storage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.data.replay.ClassIndex;
import replaybot.data.replay.Frame;
import replaybot.data.replay.NetCache;
import replaybot.data.replay.Replay;

public class ReplayDeserializer extends StdDeserializer<Replay> {

	protected ReplayDeserializer() {
		super(Replay.class);
	}

	@Override
	public Replay deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		List<Frame> frames = null; 
		List<String> objects = null;
		List<String> names = null;
		List<ClassIndex> classIndices = null;
		List<NetCache> netCache = null;
		
		JsonToken currentToken = jp.getCurrentToken();
		
		if(currentToken != JsonToken.START_OBJECT) {
			currentToken = jp.nextToken();
		}
		System.out.println(jp.nextToken());
		for(; currentToken != JsonToken.END_OBJECT; currentToken = jp.nextToken()) {
			String field = jp.getCurrentName();
			
			if("network_frames".equals(field) && currentToken == JsonToken.START_OBJECT) {
				currentToken = jp.nextValue();
				frames = jp.readValueAs(new TypeReference<List<Frame>>() {});
				currentToken = jp.nextToken();
				
			} else if("objects".equals(field) && currentToken == JsonToken.START_ARRAY) {
				 netCache = jp.readValueAs(new TypeReference<List<String>>() {});
				 
			} else if("names".equals(field) && currentToken == JsonToken.START_ARRAY) {
				 netCache = jp.readValueAs(new TypeReference<List<String>>() {});
				 
			} else if("class_indices".equals(field) && currentToken == JsonToken.START_ARRAY) {
				 classIndices = jp.readValueAs(new TypeReference<List<ClassIndex>>() {});
				
			} else if("net_cache".equals(field) && currentToken == JsonToken.START_ARRAY) {
				 netCache = jp.readValueAs(new TypeReference<List<NetCache>>() {});
				 
			} else if(currentToken == JsonToken.START_OBJECT || currentToken == JsonToken.START_ARRAY) {
				jp.skipChildren();
			}
		}
		
		return new Replay(frames, objects, names, classIndices, netCache);
	}

}
