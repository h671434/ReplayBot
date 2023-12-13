package replaybot.util;

public class NamedValue<T> {

	private String name;
	private T value;
	
	public NamedValue(String name, T value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public T getValue() {
		return value;
	} 
	
}
