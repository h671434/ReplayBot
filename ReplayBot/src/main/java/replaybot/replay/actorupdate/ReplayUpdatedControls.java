package replaybot.replay.actorupdate;

import replaybot.data.output.ControlsOutput;

public abstract class ReplayUpdatedControls implements ReplayUpdatedActor {

	private final int actorId;
	
	public ReplayUpdatedControls(int actorId) {
		this.actorId = actorId;
	}
	
	@Override
	public void applyActorUpdate() {
		// TODO get controls for current actor and update
		ControlsOutput controls;
		
		applyControlsUpdate(controls);
	}
	
	protected abstract void applyControlsUpdate(ControlsOutput controls);
	
}
