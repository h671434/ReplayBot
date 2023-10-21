package replaybot.data.replay;

import java.util.Date;

public class ReplayProperties {

	private final int teamSize;
	private final int team0Score;
	private final int team1Score;
	private final String replayName;
	private final String id;
	private final Date date;
	private final int numFrames;

	public ReplayProperties(int teamSize, int team0Score, int team1Score, String replayName, String id, Date date,
			int numFrames) {
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
