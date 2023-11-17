package replaybot.util.webrequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class RequestRateLimiter {

	private static final long MILLIS_PER_SECOND = 1000;
	private static final long MILLIS_PER_HOUR = 3600000;
	
	private int maxCallsPerSecond;
	private int maxCallsPerHour;
	private TimeNode first;
	private TimeNode last;
	private int lastHourCallCount = 0;
	
	public RequestRateLimiter(int maxCallsPerSecond, int maxCallsPerHour) {
		this.maxCallsPerSecond = maxCallsPerHour;
		this.maxCallsPerHour = maxCallsPerHour;
	}
	
	public boolean canRequest() {
		if(hasExceededMaxCallsPerHour()) {
			return false;
		}
		if(hasExceededMaxCallsPerSecond()) {
			return false;
		}
		
		return true;
	}
	
	public boolean hasExceededMaxCallsPerHour() {
		trimWithinLastHour();
		
		return lastHourCallCount >= maxCallsPerHour;
	}
	
	private void trimWithinLastHour() {
		long timeAnHourAgo = System.currentTimeMillis() - MILLIS_PER_HOUR;

		while(first != null && first.getTime() < timeAnHourAgo) {
			first = first.next;
			lastHourCallCount--;
		}
		
		if(first == null) {
			last = null;
		}
	}
	
	public boolean hasExceededMaxCallsPerSecond() {
		return countCallsWithinLastSecond() >= maxCallsPerSecond;
	}
	
	private int countCallsWithinLastSecond() {
		TimeNode current = last;
		long timeASecondAgo = System.currentTimeMillis() - MILLIS_PER_SECOND;
		int count = 0;
		
		while(current != null && current.getTime() > timeASecondAgo) {
			count++;
		}
		
		return count;
	}
	
	public void registerRequest() throws RequestRateLimitException {
		if(!canRequest()) {
			throw new RequestRateLimitException("Request rate exceeded.");
		}
		
		TimeNode newNode = new TimeNode(System.currentTimeMillis());
		
		if(first == null) {
			first = newNode;
			last = newNode;
			
			return;
		}
		
		newNode.setPrevious(last);
		last.setNext(newNode);
		last = newNode;
	}
	
	private class TimeNode {
		
		private long time;
		private TimeNode previous;
		private TimeNode next;
		
		public TimeNode(long time) {
			this.time = time;
		}

		public long getTime() {
			return time;
		}

		public TimeNode previous() {
			return previous;
		}

		public void setPrevious(TimeNode previous) {
			this.previous = previous;
		}
		
		public TimeNode next() {
			return next;
		}
		
		public void setNext(TimeNode next) {
			this.next = next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(next, previous, time);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			
			TimeNode other = (TimeNode) obj;
			
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			
			return Objects.equals(next, other.next) && Objects.equals(previous, other.previous) && time == other.time;
		}

		private RequestRateLimiter getEnclosingInstance() {
			return RequestRateLimiter.this;
		}
		
	}
	
}
