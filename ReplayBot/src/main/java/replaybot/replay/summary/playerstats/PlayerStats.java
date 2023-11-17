package replaybot.replay.summary.playerstats;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerStats {

	@JsonProperty("core")
	private PlayerCoreStats core;
	
	@JsonProperty("boost")
	private PlayerBoostStats boost;
	
	@JsonProperty("movement")
	private PlayerMovementStats movement;
	
	@JsonProperty("positioning")
	private PlayerPositioningStats positioning;
	
	@JsonProperty("demo")
	private PlayerDemoStats demo;

	@JsonProperty("ball")
	private PlayerBallStats ball;

	public PlayerStats(PlayerCoreStats core, PlayerBoostStats boost, PlayerMovementStats movement,
			PlayerPositioningStats positioning, PlayerDemoStats demo, PlayerBallStats ball) {
		this.core = core;
		this.boost = boost;
		this.movement = movement;
		this.positioning = positioning;
		this.demo = demo;
		this.ball = ball;
	}

	public PlayerCoreStats getCore() {
		return core;
	}

	public PlayerBoostStats getBoost() {
		return boost;
	}

	public PlayerMovementStats getMovement() {
		return movement;
	}

	public PlayerPositioningStats getPositioning() {
		return positioning;
	}

	public PlayerDemoStats getDemo() {
		return demo;
	}

	public PlayerBallStats getBall() {
		return ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ball, boost, core, demo, movement, positioning);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlayerStats other = (PlayerStats) obj;
		
		return Objects.equals(ball, other.ball) && Objects.equals(boost, other.boost)
				&& Objects.equals(core, other.core) && Objects.equals(demo, other.demo)
				&& Objects.equals(movement, other.movement) && Objects.equals(positioning, other.positioning);
	}

	@Override
	public String toString() {
		return "PlayerStats [core=" + core + ", boost=" + boost + ", movement=" + movement + ", positioning="
				+ positioning + ", demo=" + demo + ", ball=" + ball + "]";
	}
	
}
