package replaybot.data.replay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplayProperties {

	public int teamSize;
	
	public ReplayProperties() {
		
	}
	
	public ReplayProperties(int teamSize) {
		this.teamSize = teamSize;
	}
	

	
}
