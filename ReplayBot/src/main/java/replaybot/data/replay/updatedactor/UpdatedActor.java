package replaybot.data.replay.updatedactor;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = UpdatedActorDeserializer.class)
@FunctionalInterface
public interface UpdatedActor {

	void applyActorUpdate();
	
}
