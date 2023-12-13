package replaybot.util;

import java.util.List;

public interface RequestParameters {
 
	List<NamedValue<String>> getParameters();
	
	default String asURIQuery() {
		List<NamedValue<String>> paramList = getParameters();
		
		if(paramList.isEmpty()) {
			return "";
		}
		
		StringBuilder uriParams = new StringBuilder();
		NamedValue<String> current = paramList.get(0);
		
		uriParams.append("?" + current.getName() + "=" + current.getValue());
		
		for(int i = 1; i < paramList.size(); i++) {
			uriParams.append("&" + current.getName() + "=" + current.getValue());
		}
		
		return uriParams.toString();
	}
	
}
