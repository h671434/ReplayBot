package replaybot.rocketleague;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum RocketLeagueMap {
	
	UTUPIA_COLISEUM_DUSK("utopiastadium_dusk_p", "Utopia Coliseum (Dusk)");
	//TODO add all maps
	
	private String code;
	private String name;
	
	private RocketLeagueMap(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static RocketLeagueMap forCode(String code) {
		for (RocketLeagueMap map : RocketLeagueMap.values()) {
            if (map.code.equals(code)) {
                return map;
            }
        }
		
		return null;
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
}

