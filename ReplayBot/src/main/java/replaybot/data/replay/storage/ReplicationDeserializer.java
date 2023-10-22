package replaybot.data.replay.storage;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.data.replay.replication.Replication;

public class ReplicationDeserializer extends StdDeserializer<Replication> {

	public ReplicationDeserializer() {
		super(Replication.class);
	}

	@Override
	public Replication deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		// TODO Auto-generated method stub
		return null;
	}

}
