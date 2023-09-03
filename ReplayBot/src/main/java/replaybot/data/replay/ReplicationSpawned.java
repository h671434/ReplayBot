package replaybot.data.replay;

import replaybot.math.Vector3;

public class ReplicationSpawned extends Replication {

	private final String className;
	private final boolean flag;
	private final Vector3 initializationLocation;
	private final Vector3 initializationRotation;
	private final String name;
	private final String objectName;

	public ReplicationSpawned(int actorId, String className, boolean flag, Vector3 initializationLocation,
			Vector3 initializationRotation, String name, String objectName) {
		super(actorId);
		this.className = className;
		this.flag = flag;
		this.initializationLocation = initializationLocation;
		this.initializationRotation = initializationRotation;
		this.name = name;
		this.objectName = objectName;
	}
	
}
