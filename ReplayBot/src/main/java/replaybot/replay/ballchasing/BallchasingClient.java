package replaybot.replay.ballchasing;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;

import replaybot.util.RequestParameters;

public class BallchasingClient {
	
	private static final String API_URL = "https://ballchasing.com/api";
	private static final String AUTH_TOKEN = "pLeSdsbeotRvYb5XWtayUCtz1dYyhdyWPNShqwn2";
	
	private final HttpClient client = HttpClient.newHttpClient();
	
	public <T> HttpResponse<T> ping(BodyHandler<T> responseHandler)
			throws IOException, InterruptedException {
		HttpRequest request = getConfiguredBuilder("/")
				.GET()
				.build();
		
		return send(request, responseHandler);
	}
	
	public <T> HttpResponse<T> getReplays(ReplayFilter params, BodyHandler<T> responseHandler) 
			throws IOException, InterruptedException {
		HttpRequest request = getConfiguredBuilder("/replays", params)
				.GET()
				.build();
		
		return send(request, responseHandler);
	}
	
	public <T> HttpResponse<T> getReplay(String id, BodyHandler<T> responseHandler) 
			throws IOException, InterruptedException {
		HttpRequest request = getConfiguredBuilder("/replays/" + id)
				.GET()
				.build();
		
		return send(request, responseHandler);
	}
	
	public <T> HttpResponse<T> getReplayFile(String id, BodyHandler<T> responseHandler) 
			throws IOException, InterruptedException  {
		HttpRequest request = getConfiguredBuilder("/replays/" + id + "/file")
				.GET()
				.build();
		
		return send(request, responseHandler);
	}
	
	public <T> HttpResponse<T> getMaps(BodyHandler<T> responseHandler) 
			throws IOException, InterruptedException {
		HttpRequest request = getConfiguredBuilder("/maps")
				.GET()
				.build();
		
		return send(request, responseHandler);
	}
	
	private HttpRequest.Builder getConfiguredBuilder(String path) {
		return HttpRequest.newBuilder()
				.uri(URI.create(API_URL + path))
				.header("Authorization", AUTH_TOKEN);
	}
	
	private HttpRequest.Builder getConfiguredBuilder(String path, RequestParameters params) {
		return getConfiguredBuilder(path + params.asURIQuery());
	}
	
	private <T> HttpResponse<T> send(HttpRequest request, BodyHandler<T> responseHandler) 
			throws IOException, InterruptedException {
		return client.send(request, responseHandler);
	}
}
