package replaybot.data.replay.actor;

import replaybot.data.replay.attribute.Attribute;
import replaybot.math.Rotation;

public abstract class ReplicationActor {

	private boolean blockActors; 
	private boolean collideActors; 
	private boolean hidden; 
    private boolean tearOff; 
    private float drawScale;
    private Attribute.NotImplemented remoteRole;
    private Attribute.NotImplemented role; 
    private Rotation rotation; 
    
    public void setField(String field, Attribute attribute) throws IllegalArgumentException {
    	switch(field) {
    	case "Engine.Actor:bBlockActors" -> blockActors = attribute.asBoolean();
    	case "Engine.Actor:bCollideActors" -> collideActors = attribute.asBoolean();
    	case "Engine.Actor:bHidden" -> hidden = attribute.asBoolean();
    	case "Engine.Actor:bTearOff" -> tearOff = attribute.asBoolean();
    	case "Engine.Actor:DrawScale" -> drawScale = attribute.asFloat();
    	case "Engine.Actor:RemoteRole" -> remoteRole = attribute.asNotImplemented();
    	case "Engine.Actor:Role" -> role = attribute.asNotImplemented(); 
    	case "Engine.Actor:Rotation" -> rotation = attribute.asRotation();
    	}
    }
	
}
