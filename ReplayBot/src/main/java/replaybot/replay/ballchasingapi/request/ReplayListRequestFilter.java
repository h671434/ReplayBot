package replaybot.replay.ballchasingapi.request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import replaybot.rocketleague.RocketLeagueMatchResult;
import replaybot.rocketleague.RocketLeagueRank;
import replaybot.rocketleague.RocketLeagueMap;
import replaybot.rocketleague.RocketLeaguePlaylist;
import replaybot.rocketleague.RocketLeagueSeason;
import replaybot.util.webrequest.URLParameterBuilder;

public class ReplayListRequestFilter {
	
	public enum SortBy {
		REPLAY_DATE("replay-date"),
		UPLOAD_DATE("upload-date");
		
		private final String value;
		
		SortBy(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
	
	public enum SortDirection  {
		ASCENDING("asc"),
		DESCENDING("desc");
		
		private final String value;
		
		SortDirection(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	
	private String[] playerName = {""};
	private String[] playerId = {""};
	private Optional<String> title = Optional.empty();
	private Optional<RocketLeaguePlaylist[]> playlist = Optional.empty();
	private Optional<RocketLeagueSeason> season = Optional.empty();
	private Optional<RocketLeagueMatchResult> matchResult = Optional.empty();
	private Optional<RocketLeagueRank> minRank = Optional.empty();
	private Optional<RocketLeagueRank> maxRank = Optional.empty();
	private Optional<Boolean> pro = Optional.empty();
	private Optional<String> uploader = Optional.empty(); // supposed to be of type "SteamID64"
	private Optional<String> group = Optional.empty();
	private Optional<RocketLeagueMap> map = Optional.empty();
	private Optional<Date> createdBefore = Optional.empty(); // use RFC3339 format as filter
	private Optional<Date> createdAfter = Optional.empty();
	private Optional<Date> replayDateBefore = Optional.empty();
	private Optional<Date> replayDateAfter = Optional.empty();
	private Optional<Integer> count = Optional.empty(); // max number of returned replays. default: 150. between 1 and 200
	private Optional<SortBy> sortBy = Optional.empty(); // default: upload-date
	private Optional<SortDirection> sortDir = Optional.empty(); // default: desc
	
	public String asURLParameter() {
		URLParameterBuilder builder = new URLParameterBuilder();
		
		if(title.isPresent()) {
			builder.append("title", title.get());
		}
		
		for(String name : playerName) {
			builder.append("player-name", name);
		}
		
		for(String id : playerId) {
			builder.append("player-id", id);
		}
		
		if(playlist.isPresent()) {
			for(RocketLeaguePlaylist list : playlist.get()) {
				builder.append("playlist", list.getId());
			}
		}
		
		if(season.isPresent()) {
			builder.append("season", season.get().getCode());
		}
		
		if(matchResult.isPresent()) {
			builder.append("match-result", matchResult.get().getValue());
		}
		
		if(minRank.isPresent()) {
			builder.append("min-rank", minRank.get().getCode());
		}
		
		if(maxRank.isPresent()) {
			builder.append("max-rank", maxRank.get().getCode());
		}
		
		if(pro.isPresent()) {
			builder.append("pro", pro.get() ? "true" : "false");
		}
		
		if(uploader.isPresent()) {
			builder.append("uploader", uploader.get());
		}
		
		if(group.isPresent()) {
			builder.append("group", group.get());
		}
		
		if(map.isPresent()) {
			builder.append("map", map.get().getCode());
		}
		
		if(createdBefore.isPresent()) {
			builder.append("created-before", DATE_FORMAT.format(createdBefore.get()));
		}
		
		if(createdAfter.isPresent()) {
			builder.append("created-after", DATE_FORMAT.format(createdAfter.get()));
		}
		
		if(replayDateAfter.isPresent()) {
			builder.append("replay-date-before", DATE_FORMAT.format(replayDateAfter.get()));
		}
		
		if(replayDateBefore.isPresent()) {
			builder.append("replay-date-before", DATE_FORMAT.format(replayDateBefore.get()));
		}
		
		if(count.isPresent()) {
			builder.append("count", count.get() + "");
		}
		
		if(sortBy.isPresent()) {
			builder.append("sort-by", sortBy.get().getValue());
		}
		
		if(sortDir.isPresent()) {
			builder.append("sort-dir", sortDir.get().getValue());
		}
		
		
		return builder.build();
	}
	
	public static ReplayListRequestFilter.Builder builder() {
		return new ReplayListRequestFilter.Builder();
	}
	
	protected static class Builder {
		
		private ReplayListRequestFilter obj = new ReplayListRequestFilter();
		
		public ReplayListRequestFilter.Builder withPlayerName(String... playerName) {
			obj.playerName = playerName;
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withPlayerId(String... playerId) {
			obj.playerId = playerId;
			
			return this;
		}

		public ReplayListRequestFilter.Builder withTitle(String title){
			obj.title = Optional.of(title);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withPlaylist(RocketLeaguePlaylist... playlist) {
			obj.playlist = Optional.of(playlist);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withSeason(RocketLeagueSeason season) {
			obj.season = Optional.of(season);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withMatchResult(RocketLeagueMatchResult matchResult) {
			obj.matchResult = Optional.of(matchResult);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withMinRank(RocketLeagueRank minRank) {
			obj.minRank = Optional.of(minRank);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withMaxRank(RocketLeagueRank maxRank) {
			obj.maxRank = Optional.of(maxRank);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withPro(boolean pro) {
			obj.pro = Optional.of(pro);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withUploader(String uploader) {
			obj.uploader = Optional.of(uploader);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withGroup(String group) {
			obj.group = Optional.of(group);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withCreatedBefore(Date createdBefore) {
			obj.createdBefore = Optional.of(createdBefore);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withCreatedAfter(Date createdAfter) {
			obj.createdAfter = Optional.of(createdAfter);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withReplayDateBefore(Date replayDateBefore) {
			obj.replayDateBefore = Optional.of(replayDateBefore);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withCount(int count) {
			obj.count = Optional.of(count);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withSortBy(SortBy sortBy) {
			obj.sortBy = Optional.of(sortBy);
			
			return this;
		}
		
		public ReplayListRequestFilter.Builder withSortDirection(SortDirection sortDir) {
			obj.sortDir = Optional.of(sortDir);
			
			return this;
		}
		
		public ReplayListRequestFilter build() {
			return obj;
		}
		
	}
	
}
