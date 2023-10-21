package replaybot.data.actor;

import replaybot.data.attribute.ActiveActor;
import replaybot.data.attribute.Attribute;

public class PlayerReplicationInfo extends ReplicationInfo {

	private boolean bot;
	private boolean spectator;
	private boolean readyToPlay;
	private boolean timedOut;
	private boolean waitingPlayer;
	private byte ping;
	private int playerId;
	private String playerName;
	private String remoteUserData;
	private int score;
	private ActiveActor team;
	private Attribute.NotImplemented uniqueId;
	
	@Override
	public void setField(String field, Attribute attribute) {
		switch(field) {
	    case "Engine.PlayerReplicationInfo:bBot" -> bot = attribute.asBoolean();
	    case "Engine.PlayerReplicationInfo:bIsSpectator" -> spectator = attribute.asBoolean();
	    case "Engine.PlayerReplicationInfo:bReadyToPlay" -> readyToPlay = attribute.asBoolean();
	    case "Engine.PlayerReplicationInfo:bTimedOut" -> timedOut = attribute.asBoolean();
	    case "Engine.PlayerReplicationInfo:bWaitingPlayer" -> waitingPlayer = attribute.asBoolean();
	    case "Engine.PlayerReplicationInfo:Ping" -> ping = attribute.asByte();
	    case "Engine.PlayerReplicationInfo:PlayerID" -> playerId = attribute.asInt();
	    case "Engine.PlayerReplicationInfo:PlayerName" -> playerName = attribute.asString();
	    case "Engine.PlayerReplicationInfo:RemoteUserData" -> remoteUserData = attribute.asString();
	    case "Engine.PlayerReplicationInfo:Score" -> score = attribute.asInt();
	    case "Engine.PlayerReplicationInfo:Team" -> team = attribute.asActiveActor();
	    case "Engine.PlayerReplicationInfo:UniqueId" -> uniqueId = attribute.asNotImplemented();
		default -> super.setField(field, attribute);
		}
	}
	
}
