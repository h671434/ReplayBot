package replaybot.data.storage;

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
		mapper.registerModule(new ReplayModule());
		mapper.registerModule(new AttributeModule());
	}
	
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
		
		List<String> objects = r.getObjects();
		Map<Integer, String> stuff = new HashMap<>();
		
		r.getFrames().getFrames().forEach(fr -> {
			fr.getUpdated().forEach(u -> {
				int d = u.getObjectId();
				stuff.put(d, objects.get(d));
			});
		});
		
		stuff.forEach((e, d) -> {
			System.out.println(e + " " + d);
		}); 
		
		System.out.println(stuff.size());
		
		
	}
	
}
