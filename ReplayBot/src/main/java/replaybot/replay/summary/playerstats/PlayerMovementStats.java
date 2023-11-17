package replaybot.replay.summary.playerstats;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerMovementStats {

    @JsonProperty("avg_speed")
    private int avgSpeed;

    @JsonProperty("total_distance")
    private int totalDistance;

    @JsonProperty("time_supersonic_speed")
    private float timeSupersonicSpeed;

    @JsonProperty("time_boost_speed")
    private float timeBoostSpeed;

    @JsonProperty("time_slow_speed")
    private float timeSlowSpeed;

    @JsonProperty("time_ground")
    private float timeGround;

    @JsonProperty("time_low_air")
    private float timeLowAir;

    @JsonProperty("time_high_air")
    private float timeHighAir;

    @JsonProperty("time_powerslide")
    private float timePowerslide;

    @JsonProperty("count_powerslide")
    private int countPowerslide;

    @JsonProperty("avg_powerslide_duration")
    private float avgPowerslideDuration;

    @JsonProperty("avg_speed_percentage")
    private float avgSpeedPercentage;

    @JsonProperty("percent_slow_speed")
    private float percentSlowSpeed;

    @JsonProperty("percent_boost_speed")
    private float percentBoostSpeed;

    @JsonProperty("percent_supersonic_speed")
    private float percentSupersonicSpeed;

    @JsonProperty("percent_ground")
    private float percentGround;

    @JsonProperty("percent_low_air")
    private float percentLowAir;

    @JsonProperty("percent_high_air")
    private float percentHighAir;

	public PlayerMovementStats(int avgSpeed, int totalDistance, float timeSupersonicSpeed, float timeBoostSpeed,
			float timeSlowSpeed, float timeGround, float timeLowAir, float timeHighAir, float timePowerslide,
			int countPowerslide, float avgPowerslideDuration, float avgSpeedPercentage, float percentSlowSpeed,
			float percentBoostSpeed, float percentSupersonicSpeed, float percentGround, float percentLowAir,
			float percentHighAir) {
		this.avgSpeed = avgSpeed;
		this.totalDistance = totalDistance;
		this.timeSupersonicSpeed = timeSupersonicSpeed;
		this.timeBoostSpeed = timeBoostSpeed;
		this.timeSlowSpeed = timeSlowSpeed;
		this.timeGround = timeGround;
		this.timeLowAir = timeLowAir;
		this.timeHighAir = timeHighAir;
		this.timePowerslide = timePowerslide;
		this.countPowerslide = countPowerslide;
		this.avgPowerslideDuration = avgPowerslideDuration;
		this.avgSpeedPercentage = avgSpeedPercentage;
		this.percentSlowSpeed = percentSlowSpeed;
		this.percentBoostSpeed = percentBoostSpeed;
		this.percentSupersonicSpeed = percentSupersonicSpeed;
		this.percentGround = percentGround;
		this.percentLowAir = percentLowAir;
		this.percentHighAir = percentHighAir;
	}

	public int getAvgSpeed() {
		return avgSpeed;
	}

	public int getTotalDistance() {
		return totalDistance;
	}

	public float getTimeSupersonicSpeed() {
		return timeSupersonicSpeed;
	}

	public float getTimeBoostSpeed() {
		return timeBoostSpeed;
	}

	public float getTimeSlowSpeed() {
		return timeSlowSpeed;
	}

	public float getTimeGround() {
		return timeGround;
	}

	public float getTimeLowAir() {
		return timeLowAir;
	}

	public float getTimeHighAir() {
		return timeHighAir;
	}

	public float getTimePowerslide() {
		return timePowerslide;
	}

	public int getCountPowerslide() {
		return countPowerslide;
	}

	public float getAvgPowerslideDuration() {
		return avgPowerslideDuration;
	}

	public float getAvgSpeedPercentage() {
		return avgSpeedPercentage;
	}

	public float getPercentSlowSpeed() {
		return percentSlowSpeed;
	}

	public float getPercentBoostSpeed() {
		return percentBoostSpeed;
	}

	public float getPercentSupersonicSpeed() {
		return percentSupersonicSpeed;
	}

	public float getPercentGround() {
		return percentGround;
	}

	public float getPercentLowAir() {
		return percentLowAir;
	}

	public float getPercentHighAir() {
		return percentHighAir;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avgPowerslideDuration, avgSpeed, avgSpeedPercentage, countPowerslide, percentBoostSpeed,
				percentGround, percentHighAir, percentLowAir, percentSlowSpeed, percentSupersonicSpeed, timeBoostSpeed,
				timeGround, timeHighAir, timeLowAir, timePowerslide, timeSlowSpeed, timeSupersonicSpeed, totalDistance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlayerMovementStats other = (PlayerMovementStats) obj;
		
		return Float.floatToIntBits(avgPowerslideDuration) == Float.floatToIntBits(other.avgPowerslideDuration)
				&& avgSpeed == other.avgSpeed
				&& Float.floatToIntBits(avgSpeedPercentage) == Float.floatToIntBits(other.avgSpeedPercentage)
				&& countPowerslide == other.countPowerslide
				&& Float.floatToIntBits(percentBoostSpeed) == Float.floatToIntBits(other.percentBoostSpeed)
				&& Float.floatToIntBits(percentGround) == Float.floatToIntBits(other.percentGround)
				&& Float.floatToIntBits(percentHighAir) == Float.floatToIntBits(other.percentHighAir)
				&& Float.floatToIntBits(percentLowAir) == Float.floatToIntBits(other.percentLowAir)
				&& Float.floatToIntBits(percentSlowSpeed) == Float.floatToIntBits(other.percentSlowSpeed)
				&& Float.floatToIntBits(percentSupersonicSpeed) == Float.floatToIntBits(other.percentSupersonicSpeed)
				&& Float.floatToIntBits(timeBoostSpeed) == Float.floatToIntBits(other.timeBoostSpeed)
				&& Float.floatToIntBits(timeGround) == Float.floatToIntBits(other.timeGround)
				&& Float.floatToIntBits(timeHighAir) == Float.floatToIntBits(other.timeHighAir)
				&& Float.floatToIntBits(timeLowAir) == Float.floatToIntBits(other.timeLowAir)
				&& Float.floatToIntBits(timePowerslide) == Float.floatToIntBits(other.timePowerslide)
				&& Float.floatToIntBits(timeSlowSpeed) == Float.floatToIntBits(other.timeSlowSpeed)
				&& Float.floatToIntBits(timeSupersonicSpeed) == Float.floatToIntBits(other.timeSupersonicSpeed)
				&& totalDistance == other.totalDistance;
	}

	@Override
	public String toString() {
		return "PlayerMovementStats [avgSpeed=" + avgSpeed + ", totalDistance=" + totalDistance
				+ ", timeSupersonicSpeed=" + timeSupersonicSpeed + ", timeBoostSpeed=" + timeBoostSpeed
				+ ", timeSlowSpeed=" + timeSlowSpeed + ", timeGround=" + timeGround + ", timeLowAir=" + timeLowAir
				+ ", timeHighAir=" + timeHighAir + ", timePowerslide=" + timePowerslide + ", countPowerslide="
				+ countPowerslide + ", avgPowerslideDuration=" + avgPowerslideDuration + ", avgSpeedPercentage="
				+ avgSpeedPercentage + ", percentSlowSpeed=" + percentSlowSpeed + ", percentBoostSpeed="
				+ percentBoostSpeed + ", percentSupersonicSpeed=" + percentSupersonicSpeed + ", percentGround="
				+ percentGround + ", percentLowAir=" + percentLowAir + ", percentHighAir=" + percentHighAir + "]";
	}
  
}
