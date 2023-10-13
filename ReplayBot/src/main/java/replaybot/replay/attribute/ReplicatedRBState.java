package replaybot.replay.attribute;

import replaybot.replay.property.BiasedVector3;
import replaybot.replay.property.Rotation;

public record ReplicatedRBState (
		boolean sleeping,
		BiasedVector3 location, 
		Rotation rotation, 
		BiasedVector3 linearVelocity, 
		BiasedVector3 angularVelocity) {
	
}
