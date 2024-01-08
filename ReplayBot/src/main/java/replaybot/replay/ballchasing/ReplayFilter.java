package replaybot.replay.ballchasing;

import java.util.ArrayList;
import java.util.List;

import replaybot.util.RequestParameter;

public class ReplayFilter implements RequestParameter {

	private List<String> playerNames = new ArrayList<>();
	private List<String> playerIds = new ArrayList<>();
	
	public String asURIParameter() {
		StringBuilder params = new StringBuilder();
		
		params.append("?player-name=" + playerNames.get(0));
		
		for(int i = 1; i < playerNames.size(); i++) {
			params.append("?player-name=" + playerNames.get(i));
		}
		
		for(int i = 0; i < playerIds.size(); i++) {
			params.append("?player-id=" + playerIds.get(i));
		}
		
		return params.toString();
	}
	
}
