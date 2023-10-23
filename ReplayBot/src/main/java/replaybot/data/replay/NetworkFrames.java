package replaybot.data.replay;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkFrames implements Iterator<Frame> {
	
	private final List<Frame> frames;
	
	private Frame current = null;
	private int nextFrame = 0;
	
	@JsonCreator
	public NetworkFrames(@JsonProperty("frames") List<Frame> frames) {
		this.frames = frames;
	}
	
	@Override
	public Frame next() {
		current = frames.get(nextFrame++);
		
		return current;
	}
	
	public boolean hasNext() {
		return nextFrame < frames.size(); 
	}
	
	public List<Frame> getFrames() {
		return  frames;
	}
	
}
