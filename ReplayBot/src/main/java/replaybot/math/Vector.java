package replaybot.math;

import java.util.Collections;
import java.util.List;

public class Vector {

	private final List<Double> values;
	
	public Vector(List<Double> values) {
		this.values = Collections.unmodifiableList(values);
	}
	
	public double get(int index) {
		return values.get(index);
	}
	
	public List<Double> values() {
		return values;
	}
	
	public int length() {
		return values.size();
	}

}
