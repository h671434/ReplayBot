package replaybot.replay.ballchasing;

@SuppressWarnings("serial")
public class BallchasingRequestException extends Exception {

	private int statusCode = 0;
	
	public BallchasingRequestException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}
	
	public BallchasingRequestException(Throwable cause) {
		super(cause);
	}
	
}
