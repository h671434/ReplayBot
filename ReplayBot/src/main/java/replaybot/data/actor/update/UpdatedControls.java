package replaybot.data.actor.update;

import replaybot.data.ControlsOutput;
import replaybot.data.actor.Actor;

public abstract class UpdatedControls implements ActorUpdate {

	@Override
	public void update(Actor actor) {
		
	}
	
	public abstract void updateControls(ControlsOutput controls);

}
