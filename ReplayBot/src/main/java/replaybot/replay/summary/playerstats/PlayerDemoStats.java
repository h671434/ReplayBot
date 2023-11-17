package replaybot.replay.summary.playerstats;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDemoStats {

    @JsonProperty("inflicted")
    private int inflicted;

    @JsonProperty("taken")
    private int taken;

	public PlayerDemoStats(int inflicted, int taken) {
		this.inflicted = inflicted;
		this.taken = taken;
	}

	public int getInflicted() {
		return inflicted;
	}

	public int getTaken() {
		return taken;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inflicted, taken);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlayerDemoStats other = (PlayerDemoStats) obj;
		
		return inflicted == other.inflicted && taken == other.taken;
	}

	@Override
	public String toString() {
		return "PlayerDemoStats [inflicted=" + inflicted + ", taken=" + taken + "]";
	}
    
}
