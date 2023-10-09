package replaybot.data.replay.actor;

import replaybot.data.replay.attribute.ReplicatedRBState;
import replaybot.data.replay.attribute.WeldedInfo;

public class RBActorTA extends PawnX {
   
    private boolean bReplayActor;
    private boolean bFrozen;
    private boolean bIgnoreSyncing;
    
    private float maxLinearSpeed;
    private float maxAngularSpeed;
    
    private byte teleportCounter;
    
	private ReplicatedRBState replicatedRBState;
    private WeldedInfo weldedInfo;
    
}
