package replaybot.data.replay;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplayProperties {

	private final int teamSize;
	private final int team0Score;
	private final int team1Score;
	private final String replayName;
	private final String id;
	private final Date date;
	private final int numFrames;

	@JsonCreator
	public ReplayProperties(
			@JsonProperty("TeamSize") int teamSize, 
			@JsonProperty("Team0Score") int team0Score, 
			@JsonProperty("Team1Score") int team1Score, 
			@JsonProperty("ReplayName") String replayName, 
			@JsonProperty("Id") String id, 
			@JsonProperty("Date") @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss") Date date,
			@JsonProperty("NumFrames") int numFrames) {
		this.teamSize = teamSize;
		this.team0Score = team0Score;
		this.team1Score = team1Score;
		this.replayName = replayName;
		this.id = id;
		this.date = date;
		this.numFrames = numFrames;
	}
	
	public int getTeamSize() {
		return teamSize;
	}

	public int getTeam0Score() {
		return team0Score;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public String getReplayName() {
		return replayName;
	}

	public String getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public int getNumFrames() {
		return numFrames;
	}
	
}
