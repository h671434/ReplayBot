package replaybot.data.replay.actor;

public class ActorUpdateProperty<T> {

	public final String name;
	public final T value;
	
	public ActorUpdateProperty(String name, T value) {
		this.name = name;
		this.value = value;
	}
	
}
