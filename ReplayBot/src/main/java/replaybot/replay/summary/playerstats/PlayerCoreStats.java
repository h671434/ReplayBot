package replaybot.replay.summary.playerstats;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerCoreStats {

    @JsonProperty("shots")
    private int shots;

    @JsonProperty("shots_against")
    private int shotsAgainst;

    @JsonProperty("goals")
    private int goals;

    @JsonProperty("goals_against")
    private int goalsAgainst;

    @JsonProperty("saves")
    private int saves;

    @JsonProperty("assists")
    private int assists;

    @JsonProperty("score")
    private int score;

    @JsonProperty("mvp")
    private boolean mvp;

    @JsonProperty("shooting_percentage")
    private float shootingPercentage;

    public PlayerCoreStats() {}

	public PlayerCoreStats(int shots, int shotsAgainst, int goals, int goalsAgainst, int saves, int assists, int score,
			boolean mvp, float shootingPercentage) {
		this.shots = shots;
		this.shotsAgainst = shotsAgainst;
		this.goals = goals;
		this.goalsAgainst = goalsAgainst;
		this.saves = saves;
		this.assists = assists;
		this.score = score;
		this.mvp = mvp;
		this.shootingPercentage = shootingPercentage;
	}

	public int getShots() {
		return shots;
	}

	public int getShotsAgainst() {
		return shotsAgainst;
	}

	public int getGoals() {
		return goals;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public int getSaves() {
		return saves;
	}

	public int getAssists() {
		return assists;
	}

	public int getScore() {
		return score;
	}

	public boolean isMvp() {
		return mvp;
	}

	public float getShootingPercentage() {
		return shootingPercentage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assists, goals, goalsAgainst, mvp, saves, score, shootingPercentage, shots, shotsAgainst);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlayerCoreStats other = (PlayerCoreStats) obj;
		
		return assists == other.assists && goals == other.goals && goalsAgainst == other.goalsAgainst
				&& mvp == other.mvp && saves == other.saves && score == other.score
				&& Float.floatToIntBits(shootingPercentage) == Float.floatToIntBits(other.shootingPercentage)
				&& shots == other.shots && shotsAgainst == other.shotsAgainst;
	}

	@Override
	public String toString() {
		return "PlayerCoreStats [shots=" + shots + ", shotsAgainst=" + shotsAgainst + ", goals=" + goals
				+ ", goalsAgainst=" + goalsAgainst + ", saves=" + saves + ", assists=" + assists + ", score=" + score
				+ ", mvp=" + mvp + ", shootingPercentage=" + shootingPercentage + "]";
	}
    
}
