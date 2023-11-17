package replaybot.util.webrequest;

public class RequestRateLimitException extends WebRequestException {
	
	private static final long serialVersionUID = 1L;

	public RequestRateLimitException(String message) {
		super(message);
	}
}
