package replaybot.data.replay;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import replaybot.data.replay.storage.MixInModule;

public class ReadReplayStuffs {

	private static final String PATH = "src/test/resources/replays/ex.json";
	
	public static void main(String[] args){
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = new JsonFactory();
		
		mapper.registerModule(new MixInModule());
		
		factory.setCodec(mapper);
		
		System.out.println(mapper.mixInCount());
		System.out.println(mapper.findMixInClassFor(Replay.class));

		File f = new File(PATH);
		
		Replay r = null;
		try {
			JsonParser jp = factory.createParser(f);
			
			r = mapper.readValue(jp, Replay.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
