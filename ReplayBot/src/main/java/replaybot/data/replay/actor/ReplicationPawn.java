package replaybot.data.replay.actor;

import replaybot.data.replay.attribute.ActiveActor;
import replaybot.data.replay.attribute.Attribute;
import replaybot.math.Rotation;

public abstract class ReplicationPawn extends ReplicationActor {

	private ActiveActor playerReplicationInfo;
	private int healthMax; 

    @Override
    public void setField(String field, Attribute attribute) throws IllegalArgumentException {
    	switch(field) {
    	case "Engine.Pawn:ReplicationPlayerInfo" -> playerReplicationInfo = attribute.asActiveActor();
    	case "Engine.Pawn:HealthMax" -> healthMax = attribute.asInt();
    	default -> super.setField(field, attribute);
    	}
    }
	
}
