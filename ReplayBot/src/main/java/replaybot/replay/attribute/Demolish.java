package replaybot.replay.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Vector3;

public record Demolish(
		@JsonProperty("attacker_flag") boolean attackerFlag,
		@JsonProperty("attacker") int attackerActorId,
		@JsonProperty("victim_flag") boolean victimFlag,
		@JsonProperty("victim") int victimActorId,
		@JsonProperty("attack_velocity") Vector3 attackVelocity,
		@JsonProperty("victimVelocity") Vector3 victimVelocity) {

}
