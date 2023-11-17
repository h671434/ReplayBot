package replaybot.replay.summary.playerstats;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerPositioningStats {

	@JsonProperty("avg_distance_to_ball")
    private int avgDistanceToBall;

    @JsonProperty("avg_distance_to_ball_possession")
    private int avgDistanceToBallPossession;

    @JsonProperty("avg_distance_to_ball_no_possession")
    private int avgDistanceToBallNoPossession;

    @JsonProperty("avg_distance_to_mates")
    private int avgDistanceToMates;

    @JsonProperty("time_defensive_third")
    private double timeDefensiveThird;

    @JsonProperty("time_neutral_third")
    private double timeNeutralThird;

    @JsonProperty("time_offensive_third")
    private double timeOffensiveThird;

    @JsonProperty("time_defensive_half")
    private double timeDefensiveHalf;

    @JsonProperty("time_offensive_half")
    private double timeOffensiveHalf;

    @JsonProperty("time_behind_ball")
    private double timeBehindBall;

    @JsonProperty("time_infront_ball")
    private double timeInfrontBall;

    @JsonProperty("time_most_back")
    private double timeMostBack;

    @JsonProperty("time_most_forward")
    private double timeMostForward;

    @JsonProperty("time_closest_to_ball")
    private int timeClosestToBall;

    @JsonProperty("time_farthest_from_ball")
    private double timeFarthestFromBall;

    @JsonProperty("percent_defensive_third")
    private double percentDefensiveThird;

    @JsonProperty("percent_offensive_third")
    private double percentOffensiveThird;

    @JsonProperty("percent_neutral_third")
    private double percentNeutralThird;

    @JsonProperty("percent_defensive_half")
    private double percentDefensiveHalf;

    @JsonProperty("percent_offensive_half")
    private double percentOffensiveHalf;

    @JsonProperty("percent_behind_ball")
    private double percentBehindBall;

    @JsonProperty("percent_infront_ball")
    private double percentInfrontBall;

    @JsonProperty("percent_most_back")
    private double percentMostBack;

    @JsonProperty("percent_most_forward")
    private double percentMostForward;

    @JsonProperty("percent_closest_to_ball")
    private double percentClosestToBall;

    @JsonProperty("percent_farthest_from_ball")
    private double percentFarthestFromBall;

    public PlayerPositioningStats(int avgDistanceToBall, int avgDistanceToBallPossession,
			int avgDistanceToBallNoPossession, int avgDistanceToMates, double timeDefensiveThird,
			double timeNeutralThird, double timeOffensiveThird, double timeDefensiveHalf, double timeOffensiveHalf,
			double timeBehindBall, double timeInfrontBall, double timeMostBack, double timeMostForward,
			int timeClosestToBall, double timeFarthestFromBall, double percentDefensiveThird,
			double percentOffensiveThird, double percentNeutralThird, double percentDefensiveHalf,
			double percentOffensiveHalf, double percentBehindBall, double percentInfrontBall, double percentMostBack,
			double percentMostForward, double percentClosestToBall, double percentFarthestFromBall) {
		this.avgDistanceToBall = avgDistanceToBall;
		this.avgDistanceToBallPossession = avgDistanceToBallPossession;
		this.avgDistanceToBallNoPossession = avgDistanceToBallNoPossession;
		this.avgDistanceToMates = avgDistanceToMates;
		this.timeDefensiveThird = timeDefensiveThird;
		this.timeNeutralThird = timeNeutralThird;
		this.timeOffensiveThird = timeOffensiveThird;
		this.timeDefensiveHalf = timeDefensiveHalf;
		this.timeOffensiveHalf = timeOffensiveHalf;
		this.timeBehindBall = timeBehindBall;
		this.timeInfrontBall = timeInfrontBall;
		this.timeMostBack = timeMostBack;
		this.timeMostForward = timeMostForward;
		this.timeClosestToBall = timeClosestToBall;
		this.timeFarthestFromBall = timeFarthestFromBall;
		this.percentDefensiveThird = percentDefensiveThird;
		this.percentOffensiveThird = percentOffensiveThird;
		this.percentNeutralThird = percentNeutralThird;
		this.percentDefensiveHalf = percentDefensiveHalf;
		this.percentOffensiveHalf = percentOffensiveHalf;
		this.percentBehindBall = percentBehindBall;
		this.percentInfrontBall = percentInfrontBall;
		this.percentMostBack = percentMostBack;
		this.percentMostForward = percentMostForward;
		this.percentClosestToBall = percentClosestToBall;
		this.percentFarthestFromBall = percentFarthestFromBall;
	}
    
	public int getAvgDistanceToBall() {
		return avgDistanceToBall;
	}

	public int getAvgDistanceToBallPossession() {
		return avgDistanceToBallPossession;
	}

	public int getAvgDistanceToBallNoPossession() {
		return avgDistanceToBallNoPossession;
	}

	public int getAvgDistanceToMates() {
		return avgDistanceToMates;
	}

	public double getTimeDefensiveThird() {
		return timeDefensiveThird;
	}

	public double getTimeNeutralThird() {
		return timeNeutralThird;
	}

	public double getTimeOffensiveThird() {
		return timeOffensiveThird;
	}

	public double getTimeDefensiveHalf() {
		return timeDefensiveHalf;
	}

	public double getTimeOffensiveHalf() {
		return timeOffensiveHalf;
	}

	public double getTimeBehindBall() {
		return timeBehindBall;
	}

	public double getTimeInfrontBall() {
		return timeInfrontBall;
	}

	public double getTimeMostBack() {
		return timeMostBack;
	}

	public double getTimeMostForward() {
		return timeMostForward;
	}

	public int getTimeClosestToBall() {
		return timeClosestToBall;
	}

	public double getTimeFarthestFromBall() {
		return timeFarthestFromBall;
	}

	public double getPercentDefensiveThird() {
		return percentDefensiveThird;
	}

	public double getPercentOffensiveThird() {
		return percentOffensiveThird;
	}

	public double getPercentNeutralThird() {
		return percentNeutralThird;
	}

	public double getPercentDefensiveHalf() {
		return percentDefensiveHalf;
	}

	public double getPercentOffensiveHalf() {
		return percentOffensiveHalf;
	}

	public double getPercentBehindBall() {
		return percentBehindBall;
	}

	public double getPercentInfrontBall() {
		return percentInfrontBall;
	}

	public double getPercentMostBack() {
		return percentMostBack;
	}

	public double getPercentMostForward() {
		return percentMostForward;
	}

	public double getPercentClosestToBall() {
		return percentClosestToBall;
	}

	public double getPercentFarthestFromBall() {
		return percentFarthestFromBall;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avgDistanceToBall, avgDistanceToBallNoPossession, avgDistanceToBallPossession,
				avgDistanceToMates, percentBehindBall, percentClosestToBall, percentDefensiveHalf,
				percentDefensiveThird, percentFarthestFromBall, percentInfrontBall, percentMostBack, percentMostForward,
				percentNeutralThird, percentOffensiveHalf, percentOffensiveThird, timeBehindBall, timeClosestToBall,
				timeDefensiveHalf, timeDefensiveThird, timeFarthestFromBall, timeInfrontBall, timeMostBack,
				timeMostForward, timeNeutralThird, timeOffensiveHalf, timeOffensiveThird);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlayerPositioningStats other = (PlayerPositioningStats) obj;
		
		return avgDistanceToBall == other.avgDistanceToBall
				&& avgDistanceToBallNoPossession == other.avgDistanceToBallNoPossession
				&& avgDistanceToBallPossession == other.avgDistanceToBallPossession
				&& avgDistanceToMates == other.avgDistanceToMates
				&& Double.doubleToLongBits(percentBehindBall) == Double.doubleToLongBits(other.percentBehindBall)
				&& Double.doubleToLongBits(percentClosestToBall) == Double.doubleToLongBits(other.percentClosestToBall)
				&& Double.doubleToLongBits(percentDefensiveHalf) == Double.doubleToLongBits(other.percentDefensiveHalf)
				&& Double.doubleToLongBits(percentDefensiveThird) == Double
						.doubleToLongBits(other.percentDefensiveThird)
				&& Double.doubleToLongBits(percentFarthestFromBall) == Double
						.doubleToLongBits(other.percentFarthestFromBall)
				&& Double.doubleToLongBits(percentInfrontBall) == Double.doubleToLongBits(other.percentInfrontBall)
				&& Double.doubleToLongBits(percentMostBack) == Double.doubleToLongBits(other.percentMostBack)
				&& Double.doubleToLongBits(percentMostForward) == Double.doubleToLongBits(other.percentMostForward)
				&& Double.doubleToLongBits(percentNeutralThird) == Double.doubleToLongBits(other.percentNeutralThird)
				&& Double.doubleToLongBits(percentOffensiveHalf) == Double.doubleToLongBits(other.percentOffensiveHalf)
				&& Double.doubleToLongBits(percentOffensiveThird) == Double
						.doubleToLongBits(other.percentOffensiveThird)
				&& Double.doubleToLongBits(timeBehindBall) == Double.doubleToLongBits(other.timeBehindBall)
				&& timeClosestToBall == other.timeClosestToBall
				&& Double.doubleToLongBits(timeDefensiveHalf) == Double.doubleToLongBits(other.timeDefensiveHalf)
				&& Double.doubleToLongBits(timeDefensiveThird) == Double.doubleToLongBits(other.timeDefensiveThird)
				&& Double.doubleToLongBits(timeFarthestFromBall) == Double.doubleToLongBits(other.timeFarthestFromBall)
				&& Double.doubleToLongBits(timeInfrontBall) == Double.doubleToLongBits(other.timeInfrontBall)
				&& Double.doubleToLongBits(timeMostBack) == Double.doubleToLongBits(other.timeMostBack)
				&& Double.doubleToLongBits(timeMostForward) == Double.doubleToLongBits(other.timeMostForward)
				&& Double.doubleToLongBits(timeNeutralThird) == Double.doubleToLongBits(other.timeNeutralThird)
				&& Double.doubleToLongBits(timeOffensiveHalf) == Double.doubleToLongBits(other.timeOffensiveHalf)
				&& Double.doubleToLongBits(timeOffensiveThird) == Double.doubleToLongBits(other.timeOffensiveThird);
	}

	@Override
	public String toString() {
		return "PlayerPositioningStats [avgDistanceToBall=" + avgDistanceToBall + ", avgDistanceToBallPossession="
				+ avgDistanceToBallPossession + ", avgDistanceToBallNoPossession=" + avgDistanceToBallNoPossession
				+ ", avgDistanceToMates=" + avgDistanceToMates + ", timeDefensiveThird=" + timeDefensiveThird
				+ ", timeNeutralThird=" + timeNeutralThird + ", timeOffensiveThird=" + timeOffensiveThird
				+ ", timeDefensiveHalf=" + timeDefensiveHalf + ", timeOffensiveHalf=" + timeOffensiveHalf
				+ ", timeBehindBall=" + timeBehindBall + ", timeInfrontBall=" + timeInfrontBall + ", timeMostBack="
				+ timeMostBack + ", timeMostForward=" + timeMostForward + ", timeClosestToBall=" + timeClosestToBall
				+ ", timeFarthestFromBall=" + timeFarthestFromBall + ", percentDefensiveThird=" + percentDefensiveThird
				+ ", percentOffensiveThird=" + percentOffensiveThird + ", percentNeutralThird=" + percentNeutralThird
				+ ", percentDefensiveHalf=" + percentDefensiveHalf + ", percentOffensiveHalf=" + percentOffensiveHalf
				+ ", percentBehindBall=" + percentBehindBall + ", percentInfrontBall=" + percentInfrontBall
				+ ", percentMostBack=" + percentMostBack + ", percentMostForward=" + percentMostForward
				+ ", percentClosestToBall=" + percentClosestToBall + ", percentFarthestFromBall="
				+ percentFarthestFromBall + "]";
	}

}
