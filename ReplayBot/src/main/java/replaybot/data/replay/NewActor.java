package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NewActor(
		@JsonProperty("actor_id") int actorId,
		@JsonProperty("name_id") int nameId,
        @JsonProperty("object_id") int objectid,
        @JsonProperty("initial_trajectory") Trajectory initialTrajectory) {
    

}
