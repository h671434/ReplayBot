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

import replaybot.math.Vector3;
import replaybot.replay.property.CompressedWord;
import replaybot.replay.property.Initialization;
import replaybot.replay.replication.Replication;
import replaybot.replay.replication.ReplicationDestroyed;
import replaybot.replay.replication.ReplicationSpawned;
import replaybot.replay.replication.ReplicationUpdated;
import replaybot.replay.replication.UpdatedAttribute;

public class ReplicationDeserializer extends StdDeserializer<Replication> {
	
	public ReplicationDeserializer() {
		super(Replication.class);
	}

	@Override
	public Replication deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		CompressedWord actorId = null;
		Replication replication = null;
		
		JsonToken currentToken = jp.getCurrentToken();
		
		if(currentToken != JsonToken.START_OBJECT) {
			currentToken = jp.nextToken();
		}
		
		for(; currentToken != JsonToken.END_OBJECT; currentToken = jp.nextToken()) {
			if("actor_id".equals(jp.getCurrentName())) {
				actorId = jp.readValueAs(CompressedWord.class);
			} else if("value".equals(jp.getCurrentName())) {
				replication = resolveSubtypeAndDeserialize(jp, actorId);
			}
		}
		
		return replication;
	}
	
	private Replication resolveSubtypeAndDeserialize(JsonParser jp, CompressedWord actorId) throws JsonParseException, IOException {
		Replication value = null;
		
		JsonToken currentToken = jp.getCurrentToken();
				
		if(currentToken != JsonToken.START_OBJECT) {
			currentToken = jp.nextToken();
		}
		
		for(; currentToken != JsonToken.END_OBJECT; currentToken = jp.nextToken()) {
			if("spawned".equals(jp.getCurrentName())) {
				value = deserializeAsSpawned(jp, actorId);
			} else if("updated".equals(jp.getCurrentName())) {
				value = deserializeAsUpdated(jp, actorId);
			} else if("destroyed".equals(jp.getCurrentName())) {
				value = deserializeAsDestroyed(jp, actorId);
			}
		}
		
		return value;
	}
	
	private ReplicationSpawned deserializeAsSpawned(JsonParser jp, CompressedWord actorId) throws JsonParseException, IOException {
		String className = null;
		boolean flag = false;
		Initialization initialization = null;
		String name = null;
		int nameIndex = -1;
		int objectId = -1;
		String objectName = null;
		
		JsonToken currentToken = jp.getCurrentToken();
		
		if(currentToken != JsonToken.START_OBJECT) {
			currentToken = jp.nextToken();
		}
		
		for(; currentToken != JsonToken.END_OBJECT; currentToken = jp.nextToken()) {
			if(currentToken == JsonToken.VALUE_STRING && "class_name".equals(jp.getCurrentName())) {
				className = jp.getText();
			} else if((currentToken == JsonToken.VALUE_FALSE || currentToken == JsonToken.VALUE_TRUE) && "flag".equals(jp.getCurrentName())) {
				flag = jp.getBooleanValue();
			} else if(currentToken == JsonToken.START_OBJECT && "initialization".equals(jp.getCurrentName())) {
				jp.skipChildren(); // TODO
			} else if(currentToken == JsonToken.VALUE_STRING && "name".equals(jp.getCurrentName())) {
				name = jp.getText();
			} else if(currentToken == JsonToken.VALUE_NUMBER_INT && "name_index".equals(jp.getCurrentName())) {
				nameIndex = jp.getIntValue();
			} else if(currentToken == JsonToken.VALUE_NUMBER_INT && "object_id".equals(jp.getCurrentName())) {
				objectId = jp.getIntValue();
			} else if(currentToken == JsonToken.VALUE_STRING && "object_name".equals(jp.getCurrentName())) {
				name = jp.getText();
			} 
		}
		
		return new ReplicationSpawned(actorId, className, flag, initialization, name, nameIndex, objectId, objectName);
	}
	
	private ReplicationUpdated deserializeAsUpdated(JsonParser jp, CompressedWord actorId) throws JsonParseException, IOException {
		List<UpdatedAttribute<?>> updates = new ArrayList<>();
		
		JsonToken currentToken = jp.getCurrentToken();
				
		if(currentToken != JsonToken.START_ARRAY) {
			currentToken = jp.nextToken();
		}
		
		for(; currentToken != JsonToken.END_ARRAY; currentToken = jp.nextToken()) {
			if(currentToken == JsonToken.START_OBJECT) {
				updates.add(jp.readValueAs(UpdatedAttribute.class));
			}
		}
		
		return new ReplicationUpdated(actorId, updates);
	}
	
	private ReplicationDestroyed deserializeAsDestroyed(JsonParser jp, CompressedWord actorId) throws JsonParseException, IOException {
		if(jp.getCurrentToken() != JsonToken.START_ARRAY) {
			jp.nextToken();
		}
		
		jp.skipChildren();
		
		return new ReplicationDestroyed(actorId);
	}

}
