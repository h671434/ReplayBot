package replaybot.replay.summary;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.replay.attribute.PlatformId;
import replaybot.replay.summary.playerstats.PlayerStats;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerSummary {

	@JsonProperty("start_time")
	private double startTime;
	
	@JsonProperty("end_time")
	private double endTime;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("id")
	private PlatformId id;

	@JsonProperty("score")
	private String score;
	
	@JsonProperty("car_id")
	private int carId;
	
	@JsonProperty("car_name")
	private String carName;
	
	@JsonProperty("camera")
	private String cameraSettings;
	
	@JsonProperty("steering_sensitivity")
	private float steeringSensitivity;
	
	@JsonProperty("stats")
	private PlayerStats stats;

	public PlayerSummary(double startTime, double endTime, String name, PlatformId id, String score, int carId,
			String carName, String cameraSettings, float steeringSensitivity, PlayerStats stats) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;
		this.id = id;
		this.score = score;
		this.carId = carId;
		this.carName = carName;
		this.cameraSettings = cameraSettings;
		this.steeringSensitivity = steeringSensitivity;
		this.stats = stats;
	}
	
	public boolean hasStats() {
		return stats != null;
	}

	public double getStartTime() {
		return startTime;
	}

	public double getEndTime() {
		return endTime;
	}

	public String getName() {
		return name;
	}

	public PlatformId getId() {
		return id;
	}

	public String getScore() {
		return score;
	}

	public int getCarId() {
		return carId;
	}

	public String getCarName() {
		return carName;
	}

	public String getCameraSettings() {
		return cameraSettings;
	}

	public float getSteeringSensitivity() {
		return steeringSensitivity;
	}

	public PlayerStats getStats() {
		return stats;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cameraSettings, carId, carName, endTime, id, name, score, startTime, stats,
				steeringSensitivity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlayerSummary other = (PlayerSummary) obj;
		
		return Objects.equals(cameraSettings, other.cameraSettings) && carId == other.carId
				&& Objects.equals(carName, other.carName)
				&& Double.doubleToLongBits(endTime) == Double.doubleToLongBits(other.endTime)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(score, other.score)
				&& Double.doubleToLongBits(startTime) == Double.doubleToLongBits(other.startTime)
				&& Objects.equals(stats, other.stats)
				&& Float.floatToIntBits(steeringSensitivity) == Float.floatToIntBits(other.steeringSensitivity);
	}

	@Override
	public String toString() {
		return "PlayerSummary [startTime=" + startTime + ", endTime=" + endTime + ", name=" + name + ", id=" + id
				+ ", score=" + score + ", carId=" + carId + ", carName=" + carName + ", cameraSettings="
				+ cameraSettings + ", steeringSensitivity=" + steeringSensitivity + ", stats=" + stats + "]";
	}


}
