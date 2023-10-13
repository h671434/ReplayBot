package replaybot.replay.replication;

import replaybot.replay.property.CompressedWord;

public record UpdatedAttribute<T>(
		CompressedWord id, 
		String name, 
		T value)  {
	
}
