package replaybot.data.actor;

import replaybot.data.attribute.ActiveActor;
import replaybot.data.attribute.Attribute;
import replaybot.math.Rotation;

public abstract class Pawn extends Actor {

	private ActiveActor playerReplicationInfo;
	private int healthMax; 

    @Override
    public void setField(String field, Attribute attribute) throws IllegalArgumentException {
    	switch(field) {
    	case "Engine.Pawn:PlayerReplicationInfo" -> playerReplicationInfo = attribute.asActiveActor();
    	case "Engine.Pawn:HealthMax" -> healthMax = attribute.asInt();
    	default -> super.setField(field, attribute);
    	}
    }
	
}
