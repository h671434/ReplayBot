package replaybot.data.replay.actor;

import replaybot.data.replay.attribute.ActiveActor;
import replaybot.math.Vector3;

public class BallTA extends RBActorTA {
	
    // Fields related to physics and scale
    private float replicatedBallScale = 1;
    private float replicatedBallGravityScale = 1;
    private float replicatedWorldBounceScale = 1;
    private float replicatedAddedCarBounceScale = 1;
    private float replicatedBallMaxLinearSpeedScale = 1;
    
    // Fields related to game events and teams
    private ActiveActor gameEvent;
    private byte hitTeamNum;
    
    // Explosions and effects data
    // private ReplicatedExplosionData replicatedExplosionData;
    // private ReplicatedExplosionDataExtended replicatedExplosionDataExtended;
    
    // Miscellaneous
    private Vector3 magnusCoefficient;
    private boolean endOfGameHidden; // Unused field
    
    // ObjectTarget replicatedBallMesh; // ObjectTarget or active actor, idk

}
