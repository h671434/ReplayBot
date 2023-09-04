package replaybot.data.actor.update;

import replaybot.data.actor.Actor;

@FunctionalInterface
public interface ActorUpdate {
	
	void update(Actor actor);
	
}