package replaybot.data.replay;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import replaybot.data.replay.actor.ActorUpdate;
import replaybot.data.replay.actor.ActorUpdateProperty;

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
		
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
		
		for(int i = 0; i < r.amountOfFrames(); i++) {
			for(int j = 0; j < r.getFrame(i).amountOfUpdatedActors(); j++) {
				if(r.getFrame(i).getUpdatedActor(j).isNew()) {
					ActorUpdate u = r.getFrame(i).getUpdatedActor(j);


						hashSet.add(u.getActorId() + " " + u.getClassName());

				}
			}
		}


		hashSet.forEach(System.out::println);
	}

}
