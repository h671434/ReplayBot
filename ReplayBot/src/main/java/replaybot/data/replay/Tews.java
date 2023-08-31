package replaybot.data.replay;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import replaybot.data.replay.updatedactor.UpdatedActor;
import replaybot.data.replay.updatedactor.UpdatedActorDeserializer;

public class Tews {
	
	private static final String PATH = "src/main/resources/replays/example.replay.json";

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		File f = new File(PATH);

		
		Replay r = null;
		int i = 0;
		try {
			JsonParser jp = new JsonFactory().createJsonParser(f);
			r = mapper.readValue(jp, Replay.class);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(r.getFrame(6).getUpdatedActor(1));
		
		
	}

}
