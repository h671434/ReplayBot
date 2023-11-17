package replaybot.rocketleague;

public enum RocketLeagueMatchResult {
	WIN("win"),
	LOSS("loss");
	
	private final String value;
	
	RocketLeagueMatchResult(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
