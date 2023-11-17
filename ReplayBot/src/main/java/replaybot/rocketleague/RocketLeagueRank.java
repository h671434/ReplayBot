package replaybot.rocketleague;


public enum RocketLeagueRank {
	
	UNRANKED("unranked"),
	BRONZE_1("bronze-1"),
	BRONZE_2("bronze-2"),
	BRONZE_3("bronze-3"),
	SILVER_1("silver-1"),
	SILVER_2("silver-2"),
	SILVER_3("silver-3"),
	GOLD_1("gold-1"),
	GOLD_2("gold-2"),
	GOLD_3("gold-3"),
	PLATINUM_1("platinum-1"),
	PLATINUM_2("platinum-2"),
	PLATINUM_3("platinum-3"),
	DIAMOND_1("diamond-1"),
	DIAMOND_2("diamond-2"),
	DIAMOND_3("diamond-3"),
	CHAMPION_1("champion-1"),
	CHAMPION_2("champion-2"),
	CHAMPION_3("champion-3"),
	GRAND_CHAMPION_1("grand-champion-1"),
	GRAND_CHAMPION_2("grand-champion-2"),
	GRAND_CHAMPION_3("grand-champion-3"),
	SUPERSONIC_LEGEND("supersonic-legend");
	
	private final String code;
	
	RocketLeagueRank(String filterValue) {
		this.code = filterValue;
	}

	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return code;
	}
	
}
