package replaybot.util;

import java.net.http.HttpClient;
import java.net.http.HttpResponse.BodyHandler;

public class WebAPIClient {

	protected final String apiUrl;
	
	protected HttpClient client = HttpClient.newHttpClient();
	
	public WebAPIClient(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	public WebAPIRequest startRequest(String path) {
		
	}
	
	private <T> WebResponse<T> send(WebAPIRequest request, BodyHandler<T> responseBodyHandler) {
		
	}
	
	public class WebAPIRequest {
		
		private WebAPIRequest(String path) {
			
		}
		
	}
	
}
