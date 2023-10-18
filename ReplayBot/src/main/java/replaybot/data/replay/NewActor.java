package replaybot.data.replay;

public class NewActor {
    
	private final int actorId;
	private final int nameId;
	private final int objectId;
	private final Trajectory initialTrajectory;
	
	public NewActor(int actorId, int nameId, int objectId, Trajectory initialTrajectory) {
		this.actorId = actorId;
		this.nameId = nameId;
		this.objectId = objectId;
		this.initialTrajectory = initialTrajectory;
	}

	public int getActorId() {
		return actorId;
	}

	public int getNameId() {
		return nameId;
	}

	public int getObjectId() {
		return objectId;
	}

	public Trajectory getInitialTrajectory() {
		return initialTrajectory;
	}
	
}
