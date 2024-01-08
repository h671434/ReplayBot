package replaybot.replay.ballchasing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscribers;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BallchasingClient {
	
	private static final int GET_SUCCESS = 200;
	private static final int POST_SUCCESS = 201;
	private static final int PATCH_SUCCESS = 200;
	private static final int DELETE_SUCCESS = 204;
	
	private static final String API_URL = "";
	private static final String API_TOKEN = "";
	
	private HttpClient client = HttpClient.newHttpClient();
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	public boolean ping(){
		HttpRequest request = getConfiguredBuilder("/")
				.GET()
				.build();
		
		try {
			send(request);
		} catch (BallchasingRequestException e) {
			System.err.println("Unable to connect to Ballchasing.com.");
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}
	
	public GetReplaysResponse getReplays(ReplayFilter filter) 
			throws BallchasingRequestException {
		HttpRequest request = getConfiguredBuilder("/replays" + filter.asURIParameter())
				.GET()
				.build();
		
		return send(request, GetReplaysResponse.class);
	}
	
	public ReplayStats getReplay(String id) throws BallchasingRequestException {
		HttpRequest request = getConfiguredBuilder("/replays/" + id)
				.GET()
				.build();
		
		return send(request, ReplayStats.class);
	}
	
	public InputStream getReplayFile(String id) throws BallchasingRequestException {
		HttpRequest request = getConfiguredBuilder("/replays/" + id + "/file")
				.GET()
				.build();
		
		return send(request).body();
	}
	
	public Map<String, String> getMaps() throws BallchasingRequestException {
		HttpRequest request = getConfiguredBuilder("/maps")
				.GET()
				.build();
		
		HttpResponse<InputStream> response = send(request);
		TypeReference<Map<String, String>> mapReference = new TypeReference<>() {};
		
		try {
			return jsonMapper.readValue(response.body(), mapReference);
		} catch (IOException e) {
			throw new BallchasingRequestException(e);
		}
	}
 	
	private HttpRequest.Builder getConfiguredBuilder(String path) {
		return HttpRequest.newBuilder()
				.uri(URI.create(API_URL))
				.header("Authorization", API_TOKEN);
	}
	
	private <T> HttpResponse<T> send(HttpRequest request, BodyHandler<T> bodyHandler) 
			throws BallchasingRequestException {
		HttpResponse<T> response;
		
		try {
			response = client.send(request, bodyHandler);
		} catch (IOException | InterruptedException e) {
			throw new BallchasingRequestException(e);
		}

		if(!isValidResponse(response.statusCode())) {
			String error = getErrorString(response);
			
			throw new BallchasingRequestException(error, response.statusCode());
		}
		
		return response;
	}
	
	private HttpResponse<InputStream> send(HttpRequest request) throws BallchasingRequestException {
		return send(request, BodyHandlers.ofInputStream());
	}
	
	private <T> T send(HttpRequest request, Class<T> vc) throws BallchasingRequestException {
		HttpResponse<InputStream> response = send(request, BodyHandlers.ofInputStream());
		
		try {
			return jsonMapper.readValue(response.body(), vc);
		} catch (IOException e) {
			throw new BallchasingRequestException("Unable to parse responsebody.", response.statusCode());
		}
	}
	
	private boolean isValidResponse(int statusCode) {
		if(statusCode == GET_SUCCESS
				|| statusCode == POST_SUCCESS
				|| statusCode == PATCH_SUCCESS
				|| statusCode == DELETE_SUCCESS) {
			return true;
		}
		
		return false;
	}
	
	private <T> String getErrorString(HttpResponse<T> response) {
		try {
			if(response.body() instanceof InputStream body) {
				return jsonMapper.readTree(body).findValue("error").asText();
			} else if (response.body() instanceof String body) {
				return jsonMapper.readTree(body).findValue("error").asText();
			}
		} catch (IOException e) {}
		
		return "Unknown error";
	}
}
