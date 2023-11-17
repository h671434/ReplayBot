package replaybot.replay.summary;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamSummary {

	@JsonProperty("color")
	private String color;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("goals")
	private int goals;
	
	@JsonProperty("Players")
	private List<PlayerSummary> players;

	public TeamSummary(String color, String name, int goals, List<PlayerSummary> players) {
		this.color = color;
		this.name = name;
		this.goals = goals;
		this.players = players;
	}
	
	public boolean isDetailed() {
		return !players.isEmpty() && players.get(0).hasStats();
	}

	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public int getGoals() {
		return goals;
	}

	public List<PlayerSummary> getPlayers() {
		return players;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, goals, name, players);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamSummary other = (TeamSummary) obj;
		return Objects.equals(color, other.color) && goals == other.goals && Objects.equals(name, other.name)
				&& Objects.equals(players, other.players);
	}

	@Override
	public String toString() {
		return "TeamSummary [color=" + color + ", name=" + name + ", goals=" + goals + ", players=" + players
				+ "]";
	}
	
}
