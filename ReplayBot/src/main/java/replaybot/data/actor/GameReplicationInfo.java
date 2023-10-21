package replaybot.data.actor;

import replaybot.data.attribute.ActiveActor;
import replaybot.data.attribute.Attribute;

public class GameReplicationInfo extends ReplicationInfo {
	
	private boolean matchIsOver;
	private ActiveActor gameClass;
	private String serverName;
	
	@Override
	public void setField(String field, Attribute attribute) {
		switch(field) {
		case "Engine.GameReplicationInfo:bMatchIsOver" -> matchIsOver = attribute.asBoolean();
		case "Engine.GameReplicationInfo:GameClass" -> gameClass = attribute.asActiveActor();
		case "Engine.GameReplicationInfo:ServerName" -> serverName = attribute.asString();
		default -> super.setField(field, attribute);
		}
	}
}