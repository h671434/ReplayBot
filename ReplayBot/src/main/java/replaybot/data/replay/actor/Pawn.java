package replaybot.data.replay.actor;

import replaybot.data.replay.attribute.ActiveActor;
import replaybot.math.Vector3;

public class Pawn extends Actor {
	
	// Player information
    private ActiveActor playerReplicationInfo;
    private int healthMax;
    
    // Character state
    private boolean isCrouched;
    private boolean isWalking;
    
    // Gameplay and movement attributes
    private boolean simulateGravity;
    private boolean canSwatTurn;
    private boolean usedByMatinee;
    private boolean rootMotionFromInterpCurve;
    private boolean fastAttachedMove;
    
    // Camera and view attributes
    private byte remoteViewPitch;
    
    // Movement and control attributes
    private float groundSpeed;
    private float airSpeed;
    private float accelRate;
    private float jumpZ;
    private float airControl;
    
    // Root motion and animation attributes
    private float rootMotionInterpRate;
    private float rootMotionInterpCurrentTime;
    private Vector3 rootMotionInterpCurveLastValue;

}
