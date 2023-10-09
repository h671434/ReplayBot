package replaybot.data.replay.actor;

public class VehicleTA extends RBActorTA {
	
    // Vehicle control and state
    private byte replicatedThrottle;
    private boolean replicatedHandbrake;
    private byte replicatedSteer;
    
    // Vehicle state and behavior
    private boolean driving;
    private boolean hasPostMatchCelebration;
    // Unused field
    private boolean podiumMode;
    
}
