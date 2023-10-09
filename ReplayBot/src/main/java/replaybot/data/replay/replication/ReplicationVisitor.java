package replaybot.data.replay.replication;

public interface ReplicationVisitor {

	public void visit(ReplicationSpawned spawned);
	
	public void visit(ReplicationUpdated updated);
	
	public void visit(ReplicationDestroyed destroyed);
	
}
