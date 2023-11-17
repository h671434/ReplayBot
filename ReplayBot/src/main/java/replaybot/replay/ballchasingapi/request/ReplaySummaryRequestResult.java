package replaybot.replay.ballchasingapi.request;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;

import replaybot.replay.ballchasingapi.BallchasingReplaySource;
import replaybot.replay.ballchasingapi.BallchasingReplaySummary;
import replaybot.util.webrequest.WebRequestException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplaySummaryRequestResult {

	public enum UploadStatus {
		OK,
		PENDING,
		FAILED;
		
		@JsonValue
		public String getStatus() {
			return this.toString().toLowerCase();
		}
	}
	
	@JsonProperty("status")
	private UploadStatus status;
	
	@JsonUnwrapped
	private BallchasingReplaySummary replaySummary;

	public ReplaySummaryRequestResult(UploadStatus uploadStatus, BallchasingReplaySummary replaySummary) {
		this.status = uploadStatus;
		this.replaySummary = replaySummary;
	}
	
	public boolean isUploaded() {
		return status.equals(UploadStatus.OK);
	}

	public UploadStatus getUploadStatus() {
		return status;
	}

	public BallchasingReplaySummary getReplaySummary() throws WebRequestException {
		if(!isUploaded()) {
			throw new WebRequestException("Replay summary is not available.");
		}
		
		return replaySummary;
	}
	
	public BallchasingReplaySource getReplaySource() {
		return replaySummary.getSource();
	}

	@Override
	public int hashCode() {
		return Objects.hash(replaySummary, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ReplaySummaryRequestResult other = (ReplaySummaryRequestResult) obj;
		
		return Objects.equals(replaySummary, other.replaySummary) && status == other.status;
	}

	@Override
	public String toString() {
		return "ReplaySummaryRequestResult [status=" + status + ", replaySummary=" + replaySummary + "]";
	}
	
}
