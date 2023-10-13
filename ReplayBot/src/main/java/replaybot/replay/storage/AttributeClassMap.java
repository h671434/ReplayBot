package replaybot.replay.storage;

import java.util.Map;

import replaybot.replay.attribute.FlaggedInt;
import replaybot.replay.attribute.ReplicatedRBState;

public class AttributeClassMap {

	private static final Map<String, Class<?>> ATTRIBUTE_CLASS_BY_NAME = 
			Map.ofEntries(
			Map.entry("byte", Byte.class),
			Map.entry("boolean", Boolean.class),
			Map.entry("int", Integer.class),
			Map.entry("float", Float.class),
			Map.entry("string", String.class),
			Map.entry("flagged_int", FlaggedInt.class),
			Map.entry("rigid_body_state", ReplicatedRBState.class));
	
	public static Class<?> get(String name) {
		return ATTRIBUTE_CLASS_BY_NAME.get(name);
	}
	
	public static boolean contains(String name) {
		return ATTRIBUTE_CLASS_BY_NAME.containsKey(name);
	}
	
}
