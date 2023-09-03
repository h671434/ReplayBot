package replaybot.util;

public class Wrapper<T> {
	
	private final T value;
	
	public Wrapper() {
		this(null);
	}
	
	public Wrapper(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
}
