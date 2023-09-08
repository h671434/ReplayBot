package replaybot.data.replay;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.Main;
import replaybot.data.replay.storage.ReplayDeserializer;

@JsonDeserialize(using = ReplayDeserializer.class)
public class Replay {

	private final ReplayProperties properties;
	private final List<ReplayFrame> frames;
	
	public Replay(ReplayProperties properties, List<ReplayFrame> frames) {
		this.properties = properties;
		this.frames = Collections.unmodifiableList(frames);
	}
	
	public ReplayProperties getProperties() {
		return properties;
	}
	
	public ReplayFrame getFrame(int index) {
		return frames.get(index);
	}
	
	public int amountOfFrames() {
		return frames.size();
	}

}
