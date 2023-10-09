package replaybot.data.replay.storage;

import java.io.IOException;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.data.replay.actor.Actor;
import replaybot.data.replay.actor.Archetypes;
import replaybot.data.replay.actor.RBActorTA;
import replaybot.data.replay.replication.ActorUpdater;
import replaybot.data.replay.replication.Replication;
import replaybot.data.replay.replication.ReplicationSpawned;

public class ReplicationDeserializer extends StdDeserializer<Replication> {

	public ReplicationDeserializer() {
		super(Replication.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Replication deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	public ReplicationSpawned deserializeSpawned() {
		String className = null;
		
		switch(className) {
		case "TAGame.Ball_TA": 
			return new ReplicationSpawned(Archetypes.defaultBall());
		case "TAGame.Car_TA":
			return new ReplicationSpawned(Archetypes.defaultCar());
		case "TAGame.CarComponent_Boost_TA":
			return new ReplicationSpawned(Archetypes.carComponentBoost());
		case "TAGame.CarComponent_FlipCar_TA":
			return new ReplicationSpawned(Archetypes.carComponentFlipCar());
		case "TAGame.CarComponent_Dodge_TA":
			return new ReplicationSpawned(Archetypes.carComponentDodge());
		case "TAGame.CarComponent_Jump_TA":
			return new ReplicationSpawned(Archetypes.carComponentJump());
		case "TAGame.CarComponent_DoubleJump_TA":
			return new ReplicationSpawned(Archetypes.carComponentDoubleJump());
		}
		
		return null;
	}
	
	public ActorUpdater deserializeUpdate() {
		String placeholder = null;
		
		String[] name = placeholder.split(":");
		String className = name[0];
		String variableName = name[1];
		
		switch(className) {
		case "TAGame.RBActor_TA":
			return deserializeRBActorUpdate(variableName);
		case "TAGame.Ball_TA": 
			return deserializeBallUpdate(variableName);
		case "TAGame.Car_TA":
			return deserializeCarUpdate(variableName);
		case "TAGame.Vehicle_TA":
			return deserializeCarUpdate(variableName);
		case "TAGame.CarComponent_Boost_TA":
			return deserializeBoostUpdate(variableName);
		case "TAGame.CarComponent_FlipCar_TA":
			return deserializeFlipCarUpdate(variableName);
		case "TAGame.CarComponent_Dodge_TA":
			return deserializeDodgeUpdate(variableName);
		case "TAGame.CarComponent_Jump_TA":
			return deserializeJumpUpdate(variableName);
		case "TAGame.CarComponent_DoubleJump_TA":
			return deserializeDoubleJumpUpdate(variableName);
		}
		
		return null;
	}
	
	public ActorUpdater deserializeRBActorUpdate(String variableName) {
		Consumer<RBActorTA> setter = (RBActorTA a) -> {};
		
		switch(variableName) {
		
		}
		
		return (Actor a) -> {
			if(a instanceof RBActorTA) {
				setter.accept((RBActorTA) a);
			}
		};
	}
	
	public ActorUpdater deserializeBallUpdate(String variableName) {
		return null;
	}
	
	public ActorUpdater deserializeVehicleUpdate(String variableName) {
		return null;
	}
	
	public ActorUpdater deserializeCarUpdate(String variableName) {
		return null;
	}
	
	public ActorUpdater deserializeBoostUpdate(String variableName) {
		return null;
	}
	
	public ActorUpdater deserializeFlipCarUpdate(String variableName) {
		return null;
	}
	
	public ActorUpdater deserializeDodgeUpdate(String variableName) {
		return null;
	}
	
	public ActorUpdater deserializeJumpUpdate(String variableName) {
		return null;
	}
	
	public ActorUpdater deserializeDoubleJumpUpdate(String variableName) {
		return null;
	}

}
