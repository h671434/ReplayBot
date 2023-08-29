package replaybot.replay;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class TestJHson {

	private static final String PATH = "C:\\Users\\Aleksander XXVI\\git\\ReplayBot\\src\\main\\resources\\replays\\example.replay.json";
	
	public static void main(String[] args) {
		Map<Integer, String> objects = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
	
		File f = new File(PATH);
		System.out.println(f);
		
		try {
			new JsonFactory();
			JsonParser jp = new JsonFactory().createJsonParser(f);
			JsonNode node = mapper.readTree(f);
			
			node.get("network_frames").get("frames").elements().forEachRemaining((JsonNode n) -> {
				n.get("updated_actors").elements().forEachRemaining((JsonNode up) -> {
					int id = up.get("object_id").intValue();
					String ob = "";
					Iterator<String> it = up.get("attribute").fieldNames();
					while(it.hasNext()) {
						ob += it.next() + "  ";
					}
					
					objects.putIfAbsent(id, ob);
				});
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder();
		objects.forEach((Integer i, String s) -> {
			builder.append(i + "=" + s + "\n");
		});
		
		System.out.println(builder.toString());
	}
	
}
