package replaybot.data.replay.replication;

import java.util.function.Consumer;

import replaybot.data.replay.actor.Actor;

@FunctionalInterface
public interface ActorUpdater {

	public void update(Actor actor);

}
