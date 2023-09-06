package replaybot.data.replay;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

class DeserializeReplayTest {

	private static final String PATH = "RocketLeagueReplayParser.Console.3.3.0/example.json";
	
	@Test
	void test() {
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = new JsonFactory();
		
		factory.setCodec(mapper);

		File f = new File(PATH);
		
		Replay r = null;
		try {
			JsonParser jp = factory.createJsonParser(f);
			
			r = mapper.readValue(jp, Replay.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(r.frames.get(0).time);
	}

}
