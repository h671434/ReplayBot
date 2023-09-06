package replaybot.data.replay.actor;

import java.util.Collections;
import java.util.List;

import replaybot.math.Vector3;

public class ActorUpdate {
	
	public final int id;
	private final int nameId;
	private final String typeName;
	private final String className;
	private final Vector3 initialPostion;
	private final Vector3 initialRotation;
	private final List<ActorUpdateProperty<?>> properties;
	
	public ActorUpdate(int id, int nameId, String typeName, String className, Vector3 initialPostion,
			Vector3 initialRotation,  List<ActorUpdateProperty<?>> properties) {
		this.id = id;
		this.nameId = nameId;
		this.typeName = typeName;
		this.className = className;
		this.initialPostion = initialPostion;
		this.initialRotation = initialRotation;
		this.properties = properties.isEmpty() ? null : Collections.unmodifiableList(properties);
	}
	
	public boolean isNew() {
		return nameId != -1;
	}
	
	public boolean isUpdated() {
		return properties != null;
	}
	
}
