package replaybot.replay.ballchasingapi;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BallchasingReplayOwner {

	@JsonProperty("steam_id")
	private String steamId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("profile_url")
	private String profileUrl;
	
	@JsonProperty("avatar")
	private String avatar;

	public BallchasingReplayOwner(String steamId, String name, String profileUrl, String avatar) {
		this.steamId = steamId;
		this.name = name;
		this.profileUrl = profileUrl;
		this.avatar = avatar;
	}

	public String getSteamId() {
		return steamId;
	}

	public String getName() {
		return name;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public String getAvatar() {
		return avatar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avatar, name, profileUrl, steamId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		BallchasingReplayOwner other = (BallchasingReplayOwner) obj;
		
		return Objects.equals(avatar, other.avatar) && Objects.equals(name, other.name)
				&& Objects.equals(profileUrl, other.profileUrl) && Objects.equals(steamId, other.steamId);
	}

	@Override
	public String toString() {
		return "BallchasingReplayOwner [steamId=" + steamId + ", name=" + name + ", profileUrl=" + profileUrl + ", avatar="
				+ avatar + "]";
	}
	
}
