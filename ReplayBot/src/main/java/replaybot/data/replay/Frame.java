package replaybot.data.replay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public record Frame (
		@JsonProperty("time") double time, 
		@JsonProperty("delta") double delta, 
		@JsonProperty("new_actors") List<NewActor> newActors,
		@JsonProperty("updated_actors") List<UpdatedAttribute> updatedActors,
		@JsonProperty("deleted_actors") List<Integer> deletedActors) {
	
}
