package replaybot.data.replay.actor;

public class ActorFactory {

	public static Actor createActor(ActorUpdate ofTypeNew) {
		if(!ofTypeNew.isNew()) {
			throw new IllegalArgumentException("ActorUpdate is not of type New");
		}
		
		//TODO
		
		return null;
	}
}
