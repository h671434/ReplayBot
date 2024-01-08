package replaybot.replay.ballchasing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReplayStats(
		@JsonProperty("id") String id,
		@JsonProperty("link") String link,
		@JsonProperty("rocket_league_id") String rocketLeagueId,
		@JsonProperty("replay_title") String replayTitle,
		@JsonProperty("map_code") String mapCode,
		@JsonProperty("mapName") String mapName) {

}
