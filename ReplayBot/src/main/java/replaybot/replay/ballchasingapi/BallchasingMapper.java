package replaybot.replay.ballchasingapi;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import replaybot.replay.ballchasingapi.request.BallchasingRequester;
import replaybot.replay.ballchasingapi.request.ReplaySummaryRequestResult;
import replaybot.util.FileUtils;
import replaybot.util.webrequest.RequestRateLimitException;
import replaybot.util.webrequest.WebRequestException;
import replaybot.util.webrequest.WebResponse;

public class BallchasingMapper {
	
	private final BallchasingRequester webRequestor = new BallchasingRequester();
	private final BallchasingJsonParser parser = new BallchasingJsonParser();
	
	public ReplaySummaryRequestResult requestReplaySummary(String replayId) throws WebRequestException, IOException  {
		WebResponse response = webRequestor.requestReplaySummary(replayId);
		
		return parser.readAsReplaySummaryRequestResult(response.getInputStream());
	}
	
	public ReplaySummaryRequestResult requestNext(ReplaySummaryRequestResult previous) {
		return previous;
		
	}
	
	
}
