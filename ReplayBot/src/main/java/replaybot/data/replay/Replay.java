package replaybot.data.replay;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import replaybot.Main;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Replay {

	@JsonProperty("properties")
	private final ReplayProperties properties;
	
    
	private List<Map<String, Object>> frames;
	
	public Replay() {
		this(null, null);
	}
	
	public Replay(ReplayProperties properties, List<Map<String, Object>> frames) {
		this.properties = properties;
		this.frames = frames;
	}
	
	@SuppressWarnings("unchecked")
	@JsonProperty("network_frames")
	private void unpackFrames(Map<String, Object> networkFrames) {
		frames = (List<Map<String, Object>>)(networkFrames.get("frames"));
	}

	public ReplayProperties getProperties() {
		return properties;
	}
	
	public ReplayFrame getFrame(int index) {
		System.out.println(frames.get(0));
		return null;
	}

}
