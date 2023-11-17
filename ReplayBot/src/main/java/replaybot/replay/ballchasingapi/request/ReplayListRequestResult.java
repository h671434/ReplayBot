package replaybot.replay.ballchasingapi.request;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.replay.ballchasingapi.BallchasingReplaySummary;

public class ReplayListRequestResult {

	@JsonProperty("count")
	private int count;
	
	@JsonProperty("list")
	private List<BallchasingReplaySummary> list;
	
	@JsonProperty("next")
	private String next;

	public ReplayListRequestResult(int count, List<BallchasingReplaySummary> list, String next) {
		this.count = count;
		this.list = list;
		this.next = next;
	}

	public int getCount() {
		return count;
	}

	public List<BallchasingReplaySummary> getList() {
		return list;
	}

	public String getNext() {
		return next;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, list, next);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplayListRequestResult other = (ReplayListRequestResult) obj;
		return count == other.count && Objects.equals(list, other.list) && Objects.equals(next, other.next);
	}
	
	
}
