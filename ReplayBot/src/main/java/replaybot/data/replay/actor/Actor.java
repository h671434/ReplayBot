package replaybot.data.replay.actor;

import replaybot.data.replay.attribute.ActiveActor;
import replaybot.math.Rotator;
import replaybot.math.Vector3;

public class Actor {
	
    private boolean bBlockActors;
    private boolean bCollideActors;
    private boolean bCollideWorld;
    private boolean bHardAttach;
    private boolean bHidden;
    private boolean bNetOwner;
    private boolean bRootMotionFromInterpCurve;
    private boolean bTearOff;
    
    private byte physics;
    private byte remoteRole;
    private byte replicatedCollisionType;
    private byte role;
    
    private float drawScale;
    
    private ActiveActor instigator;
    private ActiveActor owner;
    
    private Rotator relativeRotation;
    private Rotator rotation;
    
    private Vector3 location;
    private Vector3 relativeLocation;
	
}
