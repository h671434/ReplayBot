package replaybot.data.storage;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReplayMapper {

	private final ObjectMapper mapper;
	
	public ReplayMapper() {
		mapper = new ObjectMapper();
		mapper.registerModule(new MathModule());
		mapper.registerModule(new ReplayModule());
		mapper.registerModule(new AttributeModule());
	}
	
}
