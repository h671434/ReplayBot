package replaybot.data.replay.storage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import replaybot.data.replay.Replay;

public class ReplayMapper {

	private final ObjectMapper mapper;
	
	public ReplayMapper() {
		mapper = new ObjectMapper();
		mapper.registerModule(new MathModule());
	}
	
	
}
