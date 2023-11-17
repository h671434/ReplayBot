package replaybot.replay.ballchasingapi;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import replaybot.replay.ballchasingapi.request.ReplaySummaryRequestResult;

public class BallchasingJsonParser {

	private final ObjectMapper jsonMapper = new ObjectMapper(new JsonFactory());
	
	public ReplaySummaryRequestResult readAsReplaySummaryRequestResult(InputStream json) 
			throws StreamReadException, DatabindException, IOException {
		return jsonMapper.readValue(json, ReplaySummaryRequestResult.class);
	}
	
}
