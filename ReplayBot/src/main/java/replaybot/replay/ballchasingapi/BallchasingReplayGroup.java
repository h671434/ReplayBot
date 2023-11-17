package replaybot.replay.ballchasingapi;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BallchasingReplayGroup {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("link")
	private String link;

	public BallchasingReplayGroup(String id, String name, String link) {
		this.id = id;
		this.name = name;
		this.link = link;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, link, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		BallchasingReplayGroup other = (BallchasingReplayGroup) obj;
		
		return Objects.equals(id, other.id) && Objects.equals(link, other.link) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "BallchasingReplayGroup [id=" + id + ", name=" + name + ", link=" + link + "]";
	}
	
}
