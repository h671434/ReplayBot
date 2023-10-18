package replaybot.data.replay;

public class NewActor {
    
	private final int actorId;
	private final int nameId;
	private final int objectid;
	private final Trajectory initialTrajectory;
	
	public NewActor(int actorId, int nameId, int objectid, Trajectory initialTrajectory) {
		this.actorId = actorId;
		this.nameId = nameId;
		this.objectid = objectid;
		this.initialTrajectory = initialTrajectory;
	}
	
}
