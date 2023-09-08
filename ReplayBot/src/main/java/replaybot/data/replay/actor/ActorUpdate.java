package replaybot.data.replay.actor;

import java.util.Collections;
import java.util.List;

import replaybot.math.Vector3;

public class ActorUpdate {
	
	private final int id;
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
	
	public int getActorId() {
		return id;
	}

	public int getNameId() {
		return nameId;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getClassName() {
		return className;
	}

	public Vector3 getInitialPostion() {
		return initialPostion;
	}

	public Vector3 getInitialRotation() {
		return initialRotation;
	}
	
	public List<ActorUpdateProperty<?>> getPropertyUpdates() {
		return properties;
	}

	public ActorUpdateProperty<?> getProperty(int index) {
		return properties.get(index);
	}
	
	public int amountOfUpdatedProperties() {
		return properties.size();
	}
	
}
