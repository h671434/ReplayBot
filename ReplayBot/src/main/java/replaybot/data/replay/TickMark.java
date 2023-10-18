package replaybot.data.replay;

public class TickMark {

	private final String description;
	private final int frame;
	
	public TickMark(String description, int frame) {
		this.description = description;
		this.frame = frame;
	}

	public String getDescription() {
		return description;
	}

	public int getFrame() {
		return frame;
	}
	
}
