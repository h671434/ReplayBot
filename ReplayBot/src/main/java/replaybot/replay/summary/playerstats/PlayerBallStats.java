package replaybot.replay.summary.playerstats;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerBallStats {

	@JsonProperty("possesion_time")
	private float possesionTime;
	
	@JsonProperty("time_in_side")
	private float timeInSide;

	public PlayerBallStats(float possesionTime, float timeInSide) {
		this.possesionTime = possesionTime;
		this.timeInSide = timeInSide;
	}

	public float getPossesionTime() {
		return possesionTime;
	}

	public float getTimeInSide() {
		return timeInSide;
	}

	@Override
	public int hashCode() {
		return Objects.hash(possesionTime, timeInSide);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlayerBallStats other = (PlayerBallStats) obj;
		
		return Float.floatToIntBits(possesionTime) == Float.floatToIntBits(other.possesionTime)
				&& Float.floatToIntBits(timeInSide) == Float.floatToIntBits(other.timeInSide);
	}

	@Override
	public String toString() {
		return "PlayerBallStats [possesionTime=" + possesionTime + ", timeInSide=" + timeInSide + "]";
	}
	
	
}
