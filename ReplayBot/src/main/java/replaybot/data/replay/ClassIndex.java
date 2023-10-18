package replaybot.data.replay;

public class ClassIndex {

	private final String className;
	private final int index;
	
	public ClassIndex(String className, int index) {
		this.className = className;
		this.index = index;
	}

	public String getClassName() {
		return className;
	}
	
	public int getIndex() {
		return index;
	}
	
}
