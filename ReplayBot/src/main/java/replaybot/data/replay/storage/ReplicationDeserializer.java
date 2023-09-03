package replaybot.data.replay.storage;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.data.replay.Replication;

public class ReplicationDeserializer extends StdDeserializer<Replication> {

	protected ReplicationDeserializer() {
		super(Replication.class);
	}

	@Override
	public Replication deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}
