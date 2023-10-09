package replaybot.data.replay.actor;

import replaybot.data.replay.attribute.ActiveActor;

public class CarTA extends VehicleTA {
	
    // Attached objects
    private ActiveActor attachedPickup;
    private ActiveActor rumblePickups;
    
    // Car attributes
    private float addedCarForceMultiplier;
    private float replicatedCarScale;
    private float addedBallForceMultiplier;
    
    // Car appearance and customization
    // private TeamPaint teamPaint;
    // private ClubColors clubColors;
    
    // Demolition and destruction
    // private ReplicatedDemolish replicatedDemolish;
    // private ReplicatedDemolish2 replicatedDemolishCustomFX;
    // private DemolishDataGoalExplosion replicatedDemolishGoalExplosion;
}