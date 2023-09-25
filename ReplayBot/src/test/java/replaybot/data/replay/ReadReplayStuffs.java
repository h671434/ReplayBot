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

	private static final String PATH = "src/test/resources/replays/json/example.json";
	
	@Test
	void test() {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(PATH);
		
		Map<String, Integer> spawnednames = null;
		Map<String, String> updatednames = new LinkedHashMap<>();

		try {
			JsonNode root = mapper.readTree(file);
			
			updatednames = getUpdated(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String format = "%-70s | %-52s %n";
		
		
		System.out.println("\nUpdated : " + updatednames.size());
		updatednames.forEach((String name, String type) -> System.out.format(format, name, type));
	}
	
	public Map<String, String> getUpdated(JsonNode root) {
		Map<String, String> updatednames = new LinkedHashMap<>();
		
		JsonNode frames = root.get("content").get("body").get("frames");
		
		for(int i = 0; i < frames.size(); i++) {
			JsonNode f = frames.get(i);
			
			f.get("replications").forEach((JsonNode r) -> {		
				JsonNode updated = r.get("value").get("updated");
				
				if(updated != null) {
					updated.forEach((JsonNode u) -> {
						String n = u.get("name").asText();
						String t = u.get("value").fieldNames().next();
						
						updatednames.put(n, t);
					});
				}
			});
		};
		
		return updatednames;
	}

}
