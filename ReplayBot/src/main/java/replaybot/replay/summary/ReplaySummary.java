package replaybot.replay.summary;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import replaybot.replay.ballchasingapi.BallchasingReplaySource;
import replaybot.replay.ballchasingapi.BallchasingReplaySummary;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({ 
	@Type(BallchasingReplaySummary.class) 
})
public class ReplaySummary {
	
	@JsonProperty("rocket_league_id")
	private String rocketLeagueId;
	
	@JsonAlias({ "replay_title", "title" })
	private String replayTitle;
	
	@JsonProperty("map_code")
	private String mapCode;
	
	@JsonProperty("team_size")
	private int teamSize;
	
	@JsonProperty("playlist_id")
	private String playlistId;
	
	@JsonProperty("duration")
	private double duration;
	
	@JsonProperty("overtime_seconds")
	private double overtime_seconds = 0;
	
	@JsonProperty("season")
	private int season;
	
	@JsonProperty("season_type")
	private String seasonType;
	
	@JsonProperty("date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date date;
	
	@JsonProperty("blueTeam")
	private TeamSummary blueTeam;
	
	@JsonProperty("orangeTeam")
	private TeamSummary orangeTeam;

	public ReplaySummary(String rocketLeagueId, String replayTitle, String mapCode, int teamSize, String playlistId,
			double duration, double overtime_seconds, int season, String seasonType, Date date, TeamSummary blueTeam,
			TeamSummary orangeTeam) {
		this.rocketLeagueId = rocketLeagueId;
		this.replayTitle = replayTitle;
		this.mapCode = mapCode;
		this.teamSize = teamSize;
		this.playlistId = playlistId;
		this.duration = duration;
		this.overtime_seconds = overtime_seconds;
		this.season = season;
		this.seasonType = seasonType;
		this.date = date;
		this.blueTeam = blueTeam;
		this.orangeTeam = orangeTeam;
	}
	
	public boolean isDetailed() {
		return blueTeam.isDetailed() || orangeTeam.isDetailed();
	}

	public String getRocketLeagueId() {
		return rocketLeagueId;
	}

	public String getReplayTitle() {
		return replayTitle;
	}

	public String getMapCode() {
		return mapCode;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public String getPlaylistId() {
		return playlistId;
	}

	public double getDuration() {
		return duration;
	}

	public double getOvertime_seconds() {
		return overtime_seconds;
	}

	public int getSeason() {
		return season;
	}

	public String getSeasonType() {
		return seasonType;
	}

	public Date getDate() {
		return date;
	}

	public TeamSummary getBlueTeam() {
		return blueTeam;
	}

	public TeamSummary getOrangeTeam() {
		return orangeTeam;
	}

	@Override
	public int hashCode() {
		return Objects.hash(blueTeam, date, duration, mapCode, orangeTeam, overtime_seconds, playlistId, replayTitle,
				rocketLeagueId, season, seasonType, teamSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ReplaySummary other = (ReplaySummary) obj;
		
		return Objects.equals(blueTeam, other.blueTeam) && Objects.equals(date, other.date)
				&& Double.doubleToLongBits(duration) == Double.doubleToLongBits(other.duration)
				&& Objects.equals(mapCode, other.mapCode) && Objects.equals(orangeTeam, other.orangeTeam)
				&& Double.doubleToLongBits(overtime_seconds) == Double.doubleToLongBits(other.overtime_seconds)
				&& Objects.equals(playlistId, other.playlistId) && Objects.equals(replayTitle, other.replayTitle)
				&& Objects.equals(rocketLeagueId, other.rocketLeagueId) && season == other.season
				&& Objects.equals(seasonType, other.seasonType) && teamSize == other.teamSize;
	}

	@Override
	public String toString() {
		return "ReplaySummary [rocketLeagueId=" + rocketLeagueId + ", replayTitle=" + replayTitle + ", mapCode="
				+ mapCode + ", teamSize=" + teamSize + ", playlistId=" + playlistId + ", duration=" + duration
				+ ", overtime_seconds=" + overtime_seconds + ", season=" + season + ", seasonType=" + seasonType
				+ ", date=" + date + ", blueTeam=" + blueTeam + ", orangeTeam=" + orangeTeam + "]";
	}

}
