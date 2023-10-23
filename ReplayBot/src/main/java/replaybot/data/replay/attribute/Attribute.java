package replaybot.data.replay.attribute;

public class Attribute {

	private Object value;
	
	public <T> T getAs(Class<T> vc) {
		return vc.cast(value);
	}
	
}
