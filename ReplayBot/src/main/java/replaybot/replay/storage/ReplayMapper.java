package replaybot.replay.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ReplayMapper {

	private final ObjectMapper mapper;
	
	public ReplayMapper() {
		mapper = new ObjectMapper();
		
		init();
	}
	
	private void init() {
		mapper.registerModule(new MixinModule());
	}
	
}
