package replaybot.replay.ballchasingapi;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BallchasingReplaySource {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("link")
	private String link;
	
	@JsonProperty("created")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
	private Date created;
	
	@JsonProperty("uploader")
	private BallchasingReplayOwner uploader;
	
	@JsonProperty("visibility")
	private String visibility;
	
	@JsonProperty("groups")
	private List<BallchasingReplayGroup> groups;
	
	public BallchasingReplaySource() {}

	public BallchasingReplaySource(String id, String link, Date created, BallchasingReplayOwner uploader,
			String visibility, List<BallchasingReplayGroup> groups) {
		this.id = id;
		this.link = link;
		this.created = created;
		this.uploader = uploader;
		this.visibility = visibility;
		this.groups = groups;
	}

	public String getId() {
		return id;
	}

	public String getLink() {
		return link;
	}

	public Date getCreated() {
		return created;
	}

	public BallchasingReplayOwner getUploader() {
		return uploader;
	}

	public String getVisibility() {
		return visibility;
	}

	public List<BallchasingReplayGroup> getGroups() {
		return groups;
	}

	@Override
	public int hashCode() {
		return Objects.hash(created, groups, id, link, uploader, visibility);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		BallchasingReplaySource other = (BallchasingReplaySource) obj;
		
		return Objects.equals(created, other.created) && Objects.equals(groups, other.groups)
				&& Objects.equals(id, other.id) && Objects.equals(link, other.link)
				&& Objects.equals(uploader, other.uploader) && Objects.equals(visibility, other.visibility);
	}

	@Override
	public String toString() {
		return "BallchasingReplaySource [id=" + id + ", link=" + link + ", created=" + created + ", uploader="
				+ uploader + ", visibility=" + visibility + ", groups=" + groups + "]";
	}
	
}
