package replaybot.replay.attribute;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlatformId {

	@JsonProperty("platform")
	private String platform;
	
	@JsonProperty("id")
	private String id;

	public PlatformId(String platform, String id) {
		this.platform = platform;
		this.id = id;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, platform);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlatformId other = (PlatformId) obj;
		
		return Objects.equals(id, other.id) && Objects.equals(platform, other.platform);
	}

	@Override
	public String toString() {
		return "PlatformId [platform=" + platform + ", id=" + id + "]";
	}
	
	
}
