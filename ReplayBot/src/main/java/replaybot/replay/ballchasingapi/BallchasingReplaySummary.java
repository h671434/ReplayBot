package replaybot.replay.ballchasingapi;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import replaybot.replay.summary.ReplaySummary;
import replaybot.replay.summary.TeamSummary;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BallchasingReplaySummary extends ReplaySummary {

	@JsonUnwrapped
	private BallchasingReplaySource source;
	
	public BallchasingReplaySummary(BallchasingReplaySource source, String rocketLeagueId, String replayTitle,
			String mapCode, int teamSize, String playlistId, double duration, double overtime_seconds, int season,
			String seasonType, Date date, TeamSummary blue, TeamSummary orange) {
		super(rocketLeagueId, replayTitle, mapCode, teamSize, playlistId, duration, overtime_seconds, season,
				seasonType, date, blue, orange);
		this.source = source;
	}

	public BallchasingReplaySource getSource() {
		return source;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(source);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		BallchasingReplaySummary other = (BallchasingReplaySummary) obj;
		
		return Objects.equals(source, other.source);
	}


	

	
	
	
}
