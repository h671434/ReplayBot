package replaybot.data.replay;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import replaybot.data.storage.AttributeModule;
import replaybot.data.storage.MathModule;
import replaybot.data.storage.ReplayModule;

class DeserializeReplayTest {

	private static final String PATH = "src/test/resources/replays/ex.json";
	
	public static void main(String[] args){
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = new JsonFactory();
		
		mapper.registerModule(new ReplayModule());
		mapper.registerModule(new MathModule());
		mapper.registerModule(new AttributeModule());
		
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
