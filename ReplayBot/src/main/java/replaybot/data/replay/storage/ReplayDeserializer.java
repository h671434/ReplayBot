package replaybot.data.replay.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.data.RigidBody;
import replaybot.data.replay.Replay;
import replaybot.data.replay.ReplayFrame;
import replaybot.data.replay.ReplayProperties;
import replaybot.math.Rotation;
import replaybot.math.Vector3;
import replaybot.data.replay.actor.ActorProperties;
import replaybot.data.replay.actor.ActorUpdate;
import replaybot.data.replay.actor.ActorUpdateProperties;
import replaybot.data.replay.actor.ActorUpdateProperty;

public class ReplayDeserializer extends StdDeserializer<Replay> {
	
	private JsonToken current;
	
	public ReplayDeserializer() {
		super(Replay.class);
	}

	@Override
	public Replay deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException { 
		current = jp.getCurrentToken();
		
		if(current != JsonToken.START_OBJECT) {
			current = jp.nextToken();
		}
		
		ReplayProperties properties = null;
		List<ReplayFrame> frames = null;
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			if(current == JsonToken.START_OBJECT && "Properties".equals(jp.getCurrentName())) {
				properties = deserializeProperties(jp);
				System.out.println(1);
			} else if(current == JsonToken.START_ARRAY && "Frames".equals(jp.getCurrentName())) {
				frames = deserializeAllFrames(jp);
			} else if(current == JsonToken.START_ARRAY) {
				jp.skipChildren();
			}
		}
		
		return new Replay(properties, frames);
	}
	
	private ReplayProperties deserializeProperties(JsonParser jp) throws JsonParseException, IOException {
		jp.skipChildren();
		return null; //TODO
	}
	
	private List<ReplayFrame> deserializeAllFrames(JsonParser jp) throws JsonParseException, IOException {
		List<ReplayFrame> frames = new ArrayList<>();

		for(; current != JsonToken.END_ARRAY; current = jp.nextToken()) {	
			if(current == JsonToken.START_OBJECT) {
				frames.add(deserializeFrame(jp));
			}
		}
			
		return frames;
	}
	
	private ReplayFrame deserializeFrame(JsonParser jp) throws JsonParseException, IOException {
		double time = -1;
		double delta = -1;
		List<Integer> deletedActorIds = null;
		List<ActorUpdate> updatedActors = null;
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			if(current == JsonToken.VALUE_NUMBER_FLOAT && "Time".equals(jp.getCurrentName())) {
				time = jp.getDoubleValue();
			} else if(current == JsonToken.VALUE_NUMBER_FLOAT && "Delta".equals(jp.getCurrentName())) {
				delta = jp.getDoubleValue();
			} else if(current == JsonToken.START_ARRAY && "DeletedActorIds".equals(jp.getCurrentName())) {
				deletedActorIds = deserializeDeletedActorIds(jp);
			} else if(current == JsonToken.START_ARRAY && "ActorUpdates".equals(jp.getCurrentName())) {
				updatedActors = deserializeAllActorUpdates(jp);
			}
		}
		
		return new ReplayFrame(time, delta, deletedActorIds, updatedActors);
	}
	
	private List<Integer> deserializeDeletedActorIds(JsonParser jp) throws JsonParseException, IOException {
		List<Integer> deletedActorIds = new ArrayList<>();
		
		for(; current != JsonToken.END_ARRAY; current = jp.nextToken()) {
			if(current == JsonToken.VALUE_NUMBER_INT) {
				deletedActorIds.add(jp.getIntValue());
			} 
		}
		
		return deletedActorIds;
	}
	
	private List<ActorUpdate> deserializeAllActorUpdates(JsonParser jp) throws JsonParseException, IOException {
		List<ActorUpdate> updatedActors = new ArrayList<>();
		
		for(; current != JsonToken.END_ARRAY; current = jp.nextToken()) {
			if(current == JsonToken.START_OBJECT) {
				updatedActors.add(deserializeActorUpdate(jp));
			} 
		}
		
		return updatedActors;
	}
	
	private ActorUpdate deserializeActorUpdate(JsonParser jp) throws JsonParseException, IOException {
		int id = -1;
		int nameId = -1;
		String typeName = null;
		String className = null;
		Vector3 initialPosition = null;
		Vector3 initialRotation = null;
		List<ActorUpdateProperty<?>> properties = new ArrayList<>();
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			String fieldname = jp.getCurrentName();
			
			if(current == JsonToken.VALUE_NUMBER_INT && "Id".equals(fieldname)) {
				id = jp.getIntValue();
			} else if(current == JsonToken.VALUE_NUMBER_INT && "NameId".equals(fieldname)) {
				nameId = jp.getIntValue();
			} else if(current == JsonToken.VALUE_STRING && "TypeName".equals(fieldname)) {
				typeName = jp.getText();
			} else if(current == JsonToken.VALUE_STRING && "ClassName".equals(fieldname)) {
				className = jp.getText();
			} else if(current == JsonToken.START_OBJECT && "InitialPosition".equals(fieldname)) {
				initialPosition = deserializeVector3(jp);
			} else if(current == JsonToken.START_OBJECT && "InitialRotation".equals(fieldname)) {
				initialRotation = deserializeVector3(jp);
			} else if(current == JsonToken.VALUE_NUMBER_INT || current == JsonToken.VALUE_NUMBER_FLOAT 
					|| current == JsonToken.VALUE_FALSE || current == JsonToken.VALUE_FALSE
					|| current == JsonToken.VALUE_STRING ||current == JsonToken.START_OBJECT
					|| current == JsonToken.START_ARRAY) {
				deserializeActorUpdateProperty(jp).ifPresent(au -> properties.add(au));
			}
		}
		
		return new ActorUpdate(id, nameId, typeName, className, initialPosition, initialRotation, properties);
	}
	
	private Vector3 deserializeVector3(JsonParser jp) throws JsonParseException, IOException {
		double x = 0;
		double y = 0;
		double z = 0;
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			if(current == JsonToken.VALUE_NUMBER_FLOAT && "X".equals(jp.getCurrentName())) {
				x = jp.getDoubleValue();
			} else if(current == JsonToken.VALUE_NUMBER_FLOAT && "Y".equals(jp.getCurrentName())) {
				y = jp.getDoubleValue();
			} else if(current == JsonToken.VALUE_NUMBER_FLOAT && "Z".equals(jp.getCurrentName())) {
				z = jp.getDoubleValue();
			}
		}
		
		return new Vector3(x, y, z);
	}
	
	private Optional<ActorUpdateProperty<?>> deserializeActorUpdateProperty(JsonParser jp) throws JsonParseException, IOException {
		String name = jp.getCurrentName();
		
		if(name == null) {
			return Optional.empty();
		}
		
		ActorUpdateProperty<?> property = null;
		
		switch(name) {
		case "TAGame.RBActor_TA:ReplicatedRBState":
			property = new ActorUpdateProperty<RigidBody>(name, deserializeReplicatedRigidBody(jp));
			break;
	   case "TAGame.CrowdManager_TA:GameEvent":
       case "TAGame.CrowdActor_TA:GameEvent":
       case "TAGame.PRI_TA:PersistentCamera":
       case "TAGame.Team_TA:GameEvent":
       case "TAGame.Ball_TA:GameEvent":
       case "Engine.PlayerReplicationInfo:Team":
       case "Engine.Pawn:PlayerReplicationInfo":
       case "TAGame.PRI_TA:ReplicatedGameEvent":
       case "TAGame.CarComponent_TA:Vehicle":
       case "TAGame.Car_TA:AttachedPickup":
       case "TAGame.SpecialPickup_Targeted_TA:Targeted":
       case "TAGame.CameraSettingsActor_TA:PRI":
       case "TAGame.GameEvent_Soccar_TA:MVP":
       case "TAGame.GameEvent_Soccar_TA:MatchWinner":
       case "TAGame.GameEvent_Soccar_TA:GameWinner":
       case "Engine.ReplicatedActor_ORS:ReplicatedOwner":
       case "TAGame.Car_TA:RumblePickups":
       case "TAGame.RumblePickups_TA:AttachedPickup":
       case "TAGame.SpecialPickup_Football_TA:WeldedBall":
    	   deserializeActiveActor(jp);
           break;
       case "TAGame.GameEvent_TA:ReplicatedStateIndex":
//           asp.Data = br.ReadUInt32Max(140); // number is made up, I dont know the max yet // TODO: Revisit this. It might work well enough, but looks fishy
           break;
       case "TAGame.Team_TA:LogoData":
    	   jp.skipChildren();
//           asp.Data = LogoData.Deserialize(br);
           break;
       case "TAGame.CrowdManager_TA:ReplicatedGlobalOneShotSound":
       case "TAGame.CrowdActor_TA:ReplicatedOneShotSound":
       case "TAGame.GameEvent_TA:MatchTypeClass":
       case "Engine.GameReplicationInfo:GameClass":
       case "TAGame.GameEvent_Soccar_TA:SubRulesArchetype":
       case "TAGame.Ball_TA:ReplicatedPhysMatOverride":
//           var objectTarget = ObjectTarget.Deserialize(br);
//           asp.Data = objectTarget;
//           ValidateObjectIndex(objectTarget.ObjectIndex, objectIndexToName);
    	   jp.skipChildren();
           break;
        case "Engine.PlayerReplicationInfo:Ping":
        case "TAGame.Vehicle_TA:ReplicatedSteer":
        case "TAGame.Vehicle_TA:ReplicatedThrottle": // 0: full reverse, 128: No throttle.  255 full throttle/boosting
        case "TAGame.PRI_TA:CameraYaw":
        case "TAGame.PRI_TA:CameraPitch":
        case "TAGame.Ball_TA:HitTeamNum":
        case "TAGame.GameEvent_Soccar_TA:ReplicatedScoredOnTeam":
        case "TAGame.CarComponent_Boost_TA:ReplicatedBoostAmount":
        case "TAGame.CameraSettingsActor_TA:CameraPitch":
        case "TAGame.CameraSettingsActor_TA:CameraYaw":
        case "TAGame.PRI_TA:PawnType":
        case "TAGame.Ball_Breakout_TA:LastTeamTouch":
        case "TAGame.Ball_Haunted_TA:LastTeamTouch":
        case "TAGame.PRI_TA:ReplicatedWorstNetQualityBeyondLatency":
        case "TAGame.GameEvent_Soccar_TA:ReplicatedServerPerformanceState":
        case "TAGame.Ball_Haunted_TA:TotalActiveBeams":
        case "TAGame.Ball_Haunted_TA:DeactivatedGoalIndex":
        case "TAGame.Ball_Haunted_TA:ReplicatedBeamBrokenValue":
        	property = new ActorUpdateProperty<Byte>(name, jp.getByteValue());
        	break;
        case "Engine.Actor:Location":
        case "TAGame.CarComponent_Dodge_TA:DodgeTorque":
        case "TAGame.CarComponent_Dodge_TA:DodgeImpulse":
        case "TAGame.CarComponent_DoubleJump_TA:DoubleJumpImpulse":
        	property = new ActorUpdateProperty<Vector3>(name, deserializeVector3(jp));
            break;
        case "TAGame.GameEvent_Soccar_TA:SecondsRemaining":
        case "TAGame.GameEvent_TA:ReplicatedGameStateTimeRemaining":
        case "TAGame.CrowdActor_TA:ReplicatedCountDownNumber":
        case "TAGame.GameEvent_Team_TA:MaxTeamSize":
        case "Engine.PlayerReplicationInfo:PlayerID":
        case "TAGame.PRI_TA:TotalXP":
        case "TAGame.PRI_TA:MatchScore":
        case "TAGame.GameEvent_Soccar_TA:RoundNum":
        case "TAGame.GameEvent_TA:BotSkill":
        case "TAGame.PRI_TA:MatchShots":
        case "TAGame.PRI_TA:MatchSaves":
        case "ProjectX.GRI_X:ReplicatedGamePlaylist":
        case "Engine.TeamInfo:Score":
        case "Engine.PlayerReplicationInfo:Score":
        case "TAGame.PRI_TA:MatchGoals":
        case "TAGame.PRI_TA:MatchAssists":
        case "TAGame.PRI_TA:Title":
        case "TAGame.GameEvent_TA:ReplicatedStateName":
        case "TAGame.Team_Soccar_TA:GameScore":
        case "TAGame.GameEvent_Soccar_TA:GameTime":
        case "TAGame.CarComponent_Boost_TA:UnlimitedBoostRefCount":
        case "TAGame.CrowdActor_TA:ReplicatedRoundCountDownNumber":
        case "TAGame.Ball_Breakout_TA:DamageIndex":
        case "TAGame.PRI_TA:MatchBreakoutDamage":
        case "TAGame.PRI_TA:BotProductName":
        case "TAGame.GameEvent_TA:ReplicatedRoundCountDownNumber":
        case "TAGame.GameEvent_Soccar_TA:SeriesLength":
        case "TAGame.PRI_TA:SpectatorShortcut":
        case "Engine.Pawn:HealthMax":
        case "TAGame.GameEvent_Soccar_TA:MaxScore":
        case "TAGame.Team_TA:Difficulty":
        case "TAGame.RumblePickups_TA:ConcurrentItemCount":
        case "TAGame.PRI_TA:BotBannerProductID":
        case "TAGame.Team_TA:ClubID":
        case "TAGame.PRI_TA:ClubID":
        case "TAGame.MaxTimeWarningData_TA:EndGameWarningEpochTime":
        case "TAGame.MaxTimeWarningData_TA:EndGameEpochTime":
            property = new ActorUpdateProperty<Integer>(name, jp.getIntValue());
            break;
        case "Engine.Actor:bCollideWorld":
        case "Engine.PlayerReplicationInfo:bReadyToPlay":
        case "TAGame.Vehicle_TA:bReplicatedHandbrake":
        case "TAGame.Vehicle_TA:bDriving":
        case "Engine.Actor:bNetOwner":
        case "Engine.Actor:bBlockActors":
        case "TAGame.GameEvent_TA:bHasLeaveMatchPenalty":
        case "TAGame.PRI_TA:bUsingBehindView":
        case "TAGame.PRI_TA:bUsingSecondaryCamera": // Ball cam on when true
        case "TAGame.GameEvent_TA:ActivatorCar":
        case "TAGame.GameEvent_Soccar_TA:bOverTime":
        case "ProjectX.GRI_X:bGameStarted":
        case "Engine.Actor:bCollideActors":
        case "TAGame.PRI_TA:bReady":
        case "TAGame.RBActor_TA:bFrozen":
        case "Engine.Actor:bHidden":
        case "TAGame.CarComponent_FlipCar_TA:bFlipRight":
        case "Engine.PlayerReplicationInfo:bBot":
        case "Engine.PlayerReplicationInfo:bWaitingPlayer":
        case "TAGame.RBActor_TA:bReplayActor":
        case "TAGame.PRI_TA:bIsInSplitScreen":
        case "Engine.GameReplicationInfo:bMatchIsOver":
        case "TAGame.CarComponent_Boost_TA:bUnlimitedBoost":
        case "Engine.PlayerReplicationInfo:bIsSpectator":
        case "TAGame.GameEvent_Soccar_TA:bBallHasBeenHit":
        case "TAGame.CameraSettingsActor_TA:bUsingSecondaryCamera":
        case "TAGame.CameraSettingsActor_TA:bUsingBehindView":
        case "TAGame.PRI_TA:bOnlineLoadoutSet":
        case "TAGame.PRI_TA:bMatchMVP":
        case "TAGame.PRI_TA:bOnlineLoadoutsSet":
        case "TAGame.RBActor_TA:bIgnoreSyncing":
        case "TAGame.SpecialPickup_BallVelcro_TA:bHit":
        case "TAGame.GameEvent_TA:bCanVoteToForfeit":
        case "TAGame.SpecialPickup_BallVelcro_TA:bBroken":
        case "TAGame.GameEvent_Team_TA:bForfeit":
        case "TAGame.PRI_TA:bUsingItems":
        case "TAGame.VehiclePickup_TA:bNoPickup":
        case "TAGame.CarComponent_Boost_TA:bNoBoost":
        case "TAGame.PRI_TA:PlayerHistoryValid":
        case "TAGame.GameEvent_Soccar_TA:bUnlimitedTime":
        case "TAGame.GameEvent_Soccar_TA:bClubMatch":
        case "TAGame.GameEvent_Soccar_TA:bMatchEnded":
        case "TAGame.GameEvent_TA:bAllowReadyUp":
        case "Engine.Actor:bTearOff":
        case "Engine.PlayerReplicationInfo:bTimedOut":
        case "TAGame.CameraSettingsActor_TA:bMouseCameraToggleEnabled":
        case "TAGame.CameraSettingsActor_TA:bUsingSwivel":
        case "TAGame.Ball_Haunted_TA:bIsBallBeamed":
        case "TAGame.SpecialPickup_Rugby_TA:bBallWelded":
        case "TAGame.PRI_TA:bIsDistracted":
        case "TAGame.GameEvent_TA:bIsBotMatch":
        case "TAGame.Vehicle_TA:bHasPostMatchCelebration":
        	property = new ActorUpdateProperty<Boolean>(name, jp.getBooleanValue());
            break;
        case "Engine.GameReplicationInfo:ServerName":
        case "Engine.PlayerReplicationInfo:PlayerName":
        case "TAGame.Team_TA:CustomTeamName":
        case "Engine.PlayerReplicationInfo:RemoteUserData":
        case "TAGame.GRI_TA:NewDedicatedServerIP":
        case "ProjectX.GRI_X:MatchGUID":
        case "ProjectX.GRI_X:MatchGuid": // Can remove as duplicate in case the comparison is ever made case insensitive
        case "TAGame.PRI_TA:CurrentVoiceRoom":
        case "ProjectX.GRI_X:ReplicatedServerRegion":
        	property = new ActorUpdateProperty<String>(name, jp.getText());
            break;
        case "TAGame.CarComponent_TA:ReplicatedActive":
            // The car component is active if (ReplicatedValue%2)!=0 
            // For now I am only adding that logic to the JSON serializer
//            asp.Data = br.ReadByte();
        	property = new ActorUpdateProperty<Byte>(name, jp.getByteValue());
            break;
        case "Engine.PlayerReplicationInfo:UniqueId":
//            asp.Data = UniqueId.Deserialize(br, licenseeVersion, netVersion);
        	jp.skipChildren();
            break;
        case "TAGame.PRI_TA:PartyLeader":
//            asp.Data = PartyLeader.Deserialize(br, licenseeVersion, netVersion);
        	jp.skipChildren();
            break;
        case "TAGame.PRI_TA:ClientLoadout":
//            asp.Data = ClientLoadout.Deserialize(br);
        	jp.skipChildren();
            break;
        case "TAGame.PRI_TA:CameraSettings":
        case "TAGame.CameraSettingsActor_TA:ProfileSettings":
//            asp.Data = CameraSettings.Deserialize(br, engineVersion, licenseeVersion);
        	jp.skipChildren();
        	break;
        case "TAGame.Car_TA:TeamPaint":
        case "ProjectX.GRI_X:GameServerID":
        case "ProjectX.GRI_X:Reservations":
        	jp.skipChildren();
            break;
        case "TAGame.Car_TA:ReplicatedDemolishGoalExplosion":
//            asp.Data = ReplicatedDemolishGoalExplosion.Deserialize(br, netVersion);
        	jp.skipChildren();
        	break;
        case "TAGame.GameEvent_Soccar_TA:ReplicatedMusicStinger":
        	jp.skipChildren();
            break;
        case "TAGame.CarComponent_FlipCar_TA:FlipCarTime":
        case "TAGame.Ball_TA:ReplicatedBallScale":
        case "TAGame.CarComponent_Boost_TA:RechargeDelay":
        case "TAGame.CarComponent_Boost_TA:RechargeRate":
        case "TAGame.Ball_TA:ReplicatedAddedCarBounceScale":
        case "TAGame.Ball_TA:ReplicatedBallMaxLinearSpeedScale":
        case "TAGame.Ball_TA:ReplicatedWorldBounceScale":
        case "TAGame.CarComponent_Boost_TA:BoostModifier":
        case "Engine.Actor:DrawScale":
        case "TAGame.CrowdActor_TA:ModifiedNoise":
        case "TAGame.CarComponent_TA:ReplicatedActivityTime":
        case "TAGame.SpecialPickup_BallFreeze_TA:RepOrigSpeed":
        case "TAGame.SpecialPickup_BallVelcro_TA:AttachTime":
        case "TAGame.SpecialPickup_BallVelcro_TA:BreakTime":
        case "TAGame.Car_TA:AddedCarForceMultiplier":
        case "TAGame.Car_TA:AddedBallForceMultiplier":
        case "TAGame.PRI_TA:SteeringSensitivity":
        case "TAGame.Car_TA:ReplicatedCarScale":
        case "Engine.WorldInfo:WorldGravityZ":
        case "Engine.WorldInfo:TimeDilation":
        case "TAGame.Ball_God_TA:TargetSpeed":
        case "TAGame.Ball_TA:ReplicatedBallGravityScale":
        case "TAGame.Ball_TA:BallHitSpinScale":
        	property = new ActorUpdateProperty<Double>(name, jp.getDoubleValue());
            break;
        case "TAGame.GameEvent_SoccarPrivate_TA:MatchSettings":
//            asp.Data = PrivateMatchSettings.Deserialize(br);
        	jp.skipChildren();
            break;
        case "TAGame.PRI_TA:ClientLoadoutOnline":
//            asp.Data = ClientLoadoutOnline.Deserialize(br, engineVersion, licenseeVersion, objectIndexToName);
        	jp.skipChildren();
        	break;
        case "TAGame.GameEvent_TA:GameMode":
            break;
        case "TAGame.PRI_TA:ClientLoadoutsOnline":
        	jp.skipChildren();
//            asp.Data = ClientLoadoutsOnline.Deserialize(br, engineVersion, licenseeVersion, objectIndexToName);
            break;
        case "TAGame.PRI_TA:ClientLoadouts":
        	jp.skipChildren();
//            asp.Data = ClientLoadouts.Deserialize(br);
            break;
        case "TAGame.Team_TA:ClubColors":
        case "TAGame.Car_TA:ClubColors":
        	jp.skipChildren();
//            asp.Data = ClubColors.Deserialize(br);
            break;
        case "TAGame.RBActor_TA:WeldedInfo":
        	jp.skipChildren();
//            asp.Data = WeldedInfo.Deserialize(br, netVersion);
            break;
        case "TAGame.BreakOutActor_Platform_TA:DamageState":
        	jp.skipChildren();
//            asp.Data = DamageState.Deserialize(br, netVersion);
            break;
        case "TAGame.Ball_Breakout_TA:AppliedDamage":
        	jp.skipChildren();
//            asp.Data = AppliedDamage.Deserialize(br, netVersion);
            break;
        case "TAGame.Ball_TA:ReplicatedExplosionData":
        	jp.skipChildren();
//            asp.Data = ReplicatedExplosionData.Deserialize(br, netVersion);
            break;
        case "TAGame.Ball_TA:ReplicatedExplosionDataExtended":
        	jp.skipChildren();
//            asp.Data = ReplicatedExplosionDataExtended.Deserialize(br, netVersion);
            break;
        case "TAGame.PRI_TA:SecondaryTitle":
        case "TAGame.PRI_TA:PrimaryTitle":
        	jp.skipChildren();
//            asp.Data = Title.Deserialize(br);
            break;
        case "TAGame.PRI_TA:PlayerHistoryKey":
            // Betting ReadUInt32Max is more likely, since 14 bits is a weird number
//            asp.Data = br.ReadUInt32FromBits(14);
            break;
        case "TAGame.GameEvent_Soccar_TA:ReplicatedStatEvent":
        	jp.skipChildren();
//            asp.Data = ReplicatedStatEvent.Deserialize(br);
            break;
        case "TAGame.PRI_TA:RepStatTitles":
        	jp.skipChildren();
//            asp.Data = RepStatTitle.Deserialize(br);
            break;
        case "TAGame.Car_TA:ReplicatedDemolish_CustomFX":
        	jp.skipChildren();
//            asp.Data = ReplicatedDemolishCustomFx.Deserialize(br, netVersion);
            break;
        case "TAGame.VehiclePickup_TA:NewReplicatedPickupData":
        	jp.skipChildren();
          //  asp.Data = NewReplicatedPickupData.Deserialize(br);
            break;
        case "TAGame.RumblePickups_TA:PickupInfo":
        	jp.skipChildren();
           // asp.Data = PickupInfo.Deserialize(br);
            break;
        case "TAGame.Car_TA:ReplicatedDemolish":
        	jp.skipChildren();
           // asp.Data = ReplicatedDemolish.Deserialize(br, netVersion);
            break;
        default:
        	System.err.println(name);
		}
		
		return Optional.ofNullable(property);
	}
	
	private ActorUpdateProperties.ReplicatedRigidBody deserializeReplicatedRigidBody(JsonParser jp) throws JsonParseException, IOException {
		boolean sleeping = false;
		Vector3 position = null;
		Vector3 rotation = null;
		Vector3 linearVelocity = null;
		Vector3 angularVelocity = null;
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			if(current == JsonToken.START_OBJECT && "Position".equals(jp.getCurrentName())) {
				position = deserializeVector3(jp);
			} else if(current == JsonToken.START_OBJECT && "Rotation".equals(jp.getCurrentName())) {
				rotation = deserializeVector3(jp);
			} else if(current == JsonToken.START_OBJECT && "LinearVelocity".equals(jp.getCurrentName())) {
				linearVelocity = deserializeVector3(jp);
			} else if(current == JsonToken.START_OBJECT && "AngularVelocity".equals(jp.getCurrentName())) {
				angularVelocity = deserializeVector3(jp);
			} else if((current == JsonToken.VALUE_TRUE || current == JsonToken.VALUE_FALSE)
					&& "Sleeping".equals(jp.getCurrentName())) {
				sleeping = jp.getBooleanValue();
			}
		}
		
		return new ActorUpdateProperties.ReplicatedRigidBody(position, rotation, linearVelocity, angularVelocity, sleeping);
	}
	
	public ActorUpdateProperties.ActiveActor deserializeActiveActor(JsonParser jp) throws JsonParseException, IOException {
		boolean active = false;
		int actorId = -1;
		
		for(; current != JsonToken.END_OBJECT; current = jp.nextToken()) {
			if((current == JsonToken.VALUE_FALSE || current == JsonToken.VALUE_FALSE)
				&& "Active".equals(jp.getCurrentName())) {
				active = jp.getBooleanValue();
			} else if(current == JsonToken.VALUE_NUMBER_INT&& "ActorId".equals(jp.getCurrentName())) {
				actorId = jp.getIntValue();
			} 
		}
		
		return new ActorUpdateProperties.ActiveActor(active, actorId);
	}

}
