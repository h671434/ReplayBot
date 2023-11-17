package replaybot.replay.ballchasingapi.request;

import java.io.InputStream;

import replaybot.util.webrequest.RequestRateLimitException;
import replaybot.util.webrequest.RequestRateLimiter;
import replaybot.util.webrequest.WebRequest;
import replaybot.util.webrequest.WebRequestException;
import replaybot.util.webrequest.WebResponse;

public class BallchasingRequester {

	private static final String API_URL = "https://ballchasing.com/api/";
	private static final String AUTH_TOKEN = "pLeSdsbeotRvYb5XWtayUCtz1dYyhdyWPNShqwn2";
	
	private RequestRateLimiter getReplayListLimiter = new RequestRateLimiter(2, 500);
	private RequestRateLimiter getReplaySummaryLimiter = new RequestRateLimiter(2, 1000);
	private RequestRateLimiter getReplayFileLimiter = new RequestRateLimiter(1, 200);
	
	public boolean canRequestReplayList() {
		return getReplayListLimiter.canRequest();
	}
	
	public WebResponse requestReplayList(String parameters)	throws WebRequestException {	
		return doRateLimitedGetRequest(getReplayListLimiter, "replays", parameters);
	}
	
	public boolean canRequestReplaySummary() {
		return getReplaySummaryLimiter.canRequest();
	}
	
	public WebResponse requestReplaySummary(String replayId) throws WebRequestException {
		return doRateLimitedGetRequest(getReplaySummaryLimiter, "replays/" + replayId);
	}
	
	public boolean canRequestReplayFileDownload() {
		return getReplayFileLimiter.canRequest();
	}
	
	public WebResponse requestReplayFileDownload(String replayId) throws WebRequestException {
		return doRateLimitedGetRequest(getReplayFileLimiter, "replays/" + replayId + "/file");
	}
	
	private static WebResponse doRateLimitedGetRequest(RequestRateLimiter limiter, String url) 
			throws WebRequestException {
		limiter.registerRequest();
		
		return doGetRequest(url);
	}
	
	private static WebResponse doRateLimitedGetRequest(RequestRateLimiter limiter, String endpoint,
			String parameters) throws WebRequestException {
		return doRateLimitedGetRequest(limiter, endpoint + parameters);
	}
	
	private static WebResponse doGetRequest(String url) throws WebRequestException {
		return WebRequest.get(API_URL + url)
				.setRequestProperty("Authorization", AUTH_TOKEN)
				.getResponse();
	}
	

	
}
