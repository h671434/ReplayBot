package replaybot.replay;

import replaybot.data.input.RigidBodyState;
import replaybot.data.output.ControlsOutput;

public class ReplayActorUpdate {
		
	private final int actorId;
	private final int objectId;
	private final String attributeJson;
	
	public ReplayActorUpdate(int actorId, int objectId, String attributeJson) {
		this.actorId = actorId;
		this.objectId = objectId;
		this.attributeJson = attributeJson;
	}
	
	
}
