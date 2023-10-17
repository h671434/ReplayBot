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
import replaybot.replay.model.Frame;
import replaybot.replay.model.UpdatedAttribute;
import replaybot.replay.storage.MixinModule;

class DeserializeReplayTest {

	private static final String PATH = "src/test/resources/replays/ex.json";
	
	public static void main(String[] args){
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = new JsonFactory();
		
		mapper.registerModule(new MixinModule());
		
		factory.setCodec(mapper);

		File f = new File(PATH);
		
		Replay r = null;
		try {
			JsonParser jp = factory.createJsonParser(f);
			
			r = mapper.readValue(jp, Replay.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		List<Frame> frames = r.frames();
		
		for(int i = 0; i < frames.size(); i++) {
			printFrame(frames.get(i));
		}
		System.out.println(frames.size());
	}
	
	private static void printFrame(Frame frame) {
		StringBuilder str = new StringBuilder("Frame\n");
		
		str.append("\ttime: " + frame.time() + "\n");
		str.append("\tdelta: " + frame.delta() + "\n");
		str.append("\treplications: \n");
		
		List<UpdatedAttribute> atts = frame.updatedActors();
		
		for(int i = 0; i < atts.size(); i++) {
			str.append("\t\t" + atts.get(i).toString() + "\n");
		}
		
		System.out.println(str.toString());
	}

}
