package replaybot.data.replay.updatedactor;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.output.ControlsOutput;

@JsonDeserialize(as = UpdatedControls.class)
public abstract class UpdatedControls implements UpdatedActor {

	private final int actorId;
	
	public UpdatedControls(int actorId) {
		this.actorId = actorId;
	}
	
	@Override
	public void applyActorUpdate() {
		// TODO get controls for current actor and update
		ControlsOutput controls = null;
		
		applyControlsUpdate(controls);
	}
	
	protected abstract void applyControlsUpdate(ControlsOutput controls);
	
}
