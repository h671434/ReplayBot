package replaybot.data.replay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import replaybot.data.DataPacket;
import replaybot.data.replay.actor.Actor;
import replaybot.data.replay.actor.ActorFactory;
import replaybot.data.replay.actor.ActorUpdate;
import replaybot.data.replay.actor.BallActor;
import replaybot.data.replay.actor.CarActor;

public class ReplaySimulator {

	private final Replay replay;
	
	private final Map<Integer, Actor> actorById = new HashMap<>();
	
	private double stepLengthSeconds = 16 / 1000; // 16ms is around the same time between rlbot framework packets 
	private double currentFrameTime = 0;
	private int nextFrameIndex = 0;
	
	public ReplaySimulator(Replay replay) {
		this.replay = replay;
	}
	
	public ReplaySimulator(Replay replay, double stepLengthSeconds) {
		this.replay = replay;
		this.stepLengthSeconds = stepLengthSeconds;
	}
	
	public void simulateStep() {
		double stepEndTime = currentFrameTime + stepLengthSeconds;
		
		do {
			simulateNextFrame();
		} while(currentFrameTime < stepEndTime);
	}
	
	public void simulateNextFrame() {
		ReplayFrame currentFrame = replay.getFrame(nextFrameIndex);
		
		currentFrame.getAllUpdatedActors().forEach(this::processActorUpdate);
		currentFrame.getAllDeletedActorIds().forEach(actorById::remove);
		
		currentFrameTime = currentFrame.getTime();
		nextFrameIndex++;
	}
	
	private void processActorUpdate(ActorUpdate update) {
		if(update.isNew()) {
			actorById.put(update.getActorId(), ActorFactory.createActor(update));
		}
		if(update.isUpdated()) {
			actorById.get(update.getActorId()).applyUpdate(update);
		}
	}
	
	public DataPacket buildPacket() {
		return null;
	}
	
}
