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

import replaybot.replay.Replay;
import replaybot.replay.ReplayFrame;
import replaybot.replay.replication.Replication;

class DeserializeReplayTest {

	private static final String PATH = "src/test/resources/replays/json/newex.json";
	
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
		
		
		List<ReplayFrame> frames = r.frames();
		
		for(int i = 0; i < frames.size(); i++) {
			printFrame(frames.get(i));
		}
		System.out.println(frames.size());
	}
	
	private void printFrame(ReplayFrame frame) {
		StringBuilder str = new StringBuilder("Frame\n");
		
		str.append("\ttime: " + frame.time() + "\n");
		str.append("\tdelta: " + frame.delta() + "\n");
		str.append("\treplications: \n");
		
		List<Replication> reps = frame.replications();
		
		for(int i = 0; i < reps.size(); i++) {
			str.append("\t\t" + reps.get(i).toString() + "\n");
		}
		
		System.out.println(str.toString());
	}

}
