package replaybot.data.replay;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadReplayStuffs {

	private static final String PATH = "src/test/resources/replays/json/newex.json";
	
	@Test
	void test() {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(PATH);
		
		Map<String, String> spawnednames = new LinkedHashMap<>();
		Map<String, String> updatednames = new LinkedHashMap<>();
		int latestspawnedframe = 0;
		try {
			JsonNode root = mapper.readTree(file);
			JsonNode frames = root.get("content").get("body").get("frames");
			
			frames.forEach((JsonNode f) -> {
				f.get("replications").forEach((JsonNode r) -> {		
					JsonNode spawned = r.get("value").get("spawned");
					
					if(spawned != null) {
						String cn = spawned.get("class_name").asText();
						String n = spawned.get("name").asText();
						String t = spawned.get("object_name").asText();
						
						spawnednames.put(cn + "  " + n, t);
					}
					
					JsonNode updated = r.get("value").get("updated");
					
					if(updated != null) {
						updated.forEach((JsonNode u) -> {
							String n = u.get("name").asText();
							String t = u.get("value").fieldNames().next();
							
							updatednames.put(n, t);
						});
					}
				});
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String format = "%-70s | %-52s %n";
		
		System.out.println("Spawned : " + spawnednames.size());
		spawnednames.forEach((String name, String type) -> System.out.format(format, name, type));
		
		System.out.println("\nUpdated : " + updatednames.size());
		updatednames.forEach((String name, String type) -> System.out.format(format, name, type));
	}

}
