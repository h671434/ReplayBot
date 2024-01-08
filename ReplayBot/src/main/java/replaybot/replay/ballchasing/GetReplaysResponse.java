package replaybot.replay.ballchasing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetReplaysResponse {

	@JsonProperty("count")
	private int count;
	@JsonProperty("list")
	private List<ReplayStats> list;
	@JsonProperty("next")
	private String next;
	
}
