package replaybot.data.replay.storage;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.data.replay.ReplayFrame;
import replaybot.data.replay.ReplayProperties;
import replaybot.data.replay.replication.Destroyed;
import replaybot.data.replay.replication.Replication;
import replaybot.data.replay.replication.Spawned;
import replaybot.data.replay.replication.Updated;

public class ReplicationDeserializer extends StdDeserializer<Replication> {

	protected ReplicationDeserializer() {
		super(Replication.class);
	}

	@Override
	public Replication deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonToken current = jp.getCurrentToken();
		
		if(current != JsonToken.START_OBJECT) {
			current = jp.nextToken();
		}
		
		int actorId = 0;
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			if(current == JsonToken.START_OBJECT && "actor_id".equals(jp.getCurrentName())) {
				actorId = deserializeActorId(jp);
			}
			if(current == JsonToken.START_OBJECT && "value".equals(jp.getCurrentName())) {
				
			}
		}
		
		return null;
	}
	
	private int deserializeActorId(JsonParser jp) throws JsonParseException, IOException {
		JsonToken current = jp.getCurrentToken();
		
		if(current != JsonToken.START_OBJECT) {
			current = jp.nextToken();
		}
		
		int actorId = 0;
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			if(current == JsonToken.VALUE_NUMBER_INT && "value".equals(jp.getCurrentName())) {
				actorId = jp.getIntValue();
			}
		}
		
		return actorId;
	}
	
	private Spawned deserializeSpawned(JsonParser jp) {
		return null;
	}
	
	private Destroyed deserializeDestroyed(JsonParser jp) {
		return null;
	}
	
	private Updated deserializeUpdated(JsonParser jp) {
		return null;
	}

}
