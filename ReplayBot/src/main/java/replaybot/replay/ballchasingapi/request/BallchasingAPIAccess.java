package replaybot.replay.ballchasingapi.request;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class BallchasingAPIAccess {

	private static final String API_URL;
	private static final String AUTH_TOKEN;
	
	HttpClient client = HttpClient.newHttpClient();
	
	public void requestReplayList(String params) throws URISyntaxException {
		URI uri = new URI(API_URL + "/replays" + params);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(uri)
				.GET()
				.header("Authorization", AUTH_TOKEN)
				.build();
		
		
	}
}
