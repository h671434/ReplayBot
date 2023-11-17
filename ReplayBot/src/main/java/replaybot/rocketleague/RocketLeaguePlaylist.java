package replaybot.rocketleague;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum RocketLeaguePlaylist {
	
	UNRANKED_DUELS("unranked-duels", "Unranked Duels"), 
	UNRANKED_DOUBLES("unranked-doubles", "Unranked Doubles"), 
	UNRANKED_STANDARD("unranked-standard", "Unranked Standard"), 
	UNRANKED_CHAOS("unranked-chaos", "Unranked Chaos"),
	PRIVATE("private", "Private"), 
	SEASON("season", "Season"), 
	OFFLINE("offline", "Offline"), 
	RANKED_DUELS("ranked-duels", "Ranked Duels"), 
	RANKED_DOUBLES("ranked-doubles", "Ranked Doubles"), 
	RANKED_SOLO_STANDARD("ranked-solo-standard", "Ranked Solo Standard"), 
	RANKED_STANDARD("ranked-standard", "Ranked Standard"), 
	SNOWDAY("snowday", "Snowday"), 
	ROCKETLABS("rocketlabs", "RocketLabs"), 
	HOOPS("hoops", "Hoops"), 
	RUMBLE("rumble", "Rumble"), 
	TOURNAMENT("tournament", "Tournament"),
	DROPSHOT("dropshot", "Dropshot"), 
	RANKED_HOOPS("ranked-hoops", "Ranked Hoops"), 
	RANKED_RUMBLE("ranked-rumble", "Ranked Rumble"), 
	RANKED_DROPSHOT("ranked-dropshot", "Ranked Dropshot"), 
	RANKED_SNOWDAY("ranked-snowday", "Ranked Snowday"), 
	DROPSHOT_RUMBLE("dropshot-rumble", "Dropshot Rumble"), 
	HEATSEEKER("heatseeker", "Heatseeker");
	
	private final String id;
	private final String name;
	
	private RocketLeaguePlaylist(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static RocketLeaguePlaylist forId(String id) {
		for(RocketLeaguePlaylist playlist : RocketLeaguePlaylist.values()) {
			if(playlist.id.equals(id)) {
				return playlist;
			}
		}
		
		return null;
	}

	public String getId() {
		return id;
	}
	
}