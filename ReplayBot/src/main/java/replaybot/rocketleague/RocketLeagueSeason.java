package replaybot.rocketleague;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RocketLeagueSeason {
	
	SEASON_1(1, "old"),
	SEASON_2(2, "old"),
	SEASON_3(3, "old"),
	SEASON_4(4, "old"),
	SEASON_5(5, "old"),
	SEASON_6(6, "old"),
	SEASON_7(7, "old"),
	SEASON_8(8, "old"),
	SEASON_9(9, "old"),
	SEASON_10(10, "old"),
	SEASON_11(11, "old"),
	SEASON_12(12, "old"),
	SEASON_13(13, "old"),
	SEASON_14(14, "old"),
	SEASON_1_FREE_TO_PLAY(1, "free2play"),
	SEASON_2_FREE_TO_PLAY(2, "free2play"),
	SEASON_3_FREE_TO_PLAY(3, "free2play"),
	SEASON_4_FREE_TO_PLAY(4, "free2play"),
	SEASON_5_FREE_TO_PLAY(5, "free2play"),
	SEASON_6_FREE_TO_PLAY(6, "free2play"),
	SEASON_7_FREE_TO_PLAY(7, "free2play"),
	SEASON_8_FREE_TO_PLAY(8, "free2play"),
	SEASON_9_FREE_TO_PLAY(9, "free2play"),
	SEASON_10_FREE_TO_PLAY(10, "free2play"),
	SEASON_11_FREE_TO_PLAY(11, "free2play"),
	SEASON_12_FREE_TO_PLAY(12, "free2play");
	
	private int season;
	private String seasonType;
	
	RocketLeagueSeason(int season, String seasonType) {
		this.season = season;
		this.seasonType = seasonType;
	}
	
	public boolean isFreeToPlay() {
		return seasonType.equals("free2play");
	}
	
	public int getSeason() {
		return season;
	}
	
	public String getCode() {
		if(isFreeToPlay()) {
			return "f" + season;
		}
		
		return "" + season;
	}

}
