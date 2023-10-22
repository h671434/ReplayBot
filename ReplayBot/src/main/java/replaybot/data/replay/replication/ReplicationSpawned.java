package replaybot.data.replay.replication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class ReplicationSpawned extends Replication {
    
	private boolean flag;
	private int nameIndex;
	private String name;
	private int objectId;
	private String objectName;
	private String className;
	private SpawnInitialization initialization;
	
	public ReplicationSpawned(int actorId, boolean flag, int nameIndex, String name, int objectId,
			String objectName, String className, SpawnInitialization initialization) {
		super(actorId);
		this.flag = flag;
		this.nameIndex = nameIndex;
		this.name = name;
		this.objectId = objectId;
		this.objectName = objectName;
		this.className = className;
		this.initialization = initialization;
	}

	
}
