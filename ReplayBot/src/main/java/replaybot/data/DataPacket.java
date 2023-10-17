package replaybot.data;

import java.util.ArrayList;
import java.util.List;

import replaybot.data.actor.BallActor;
import replaybot.data.actor.Car;
import rlbot.flat.GameTickPacket;

public class DataPacket {
	
	public final double time;
	public final BallActor ball;
	public final Car car;
	public final List<Car> allCars;
	
    public DataPacket(GameTickPacket packet, int playerIndex) {
       	this.time = packet.gameInfo().secondsElapsed();
    	this.ball = new BallActor(packet.ball());
    	this.allCars = new ArrayList<>(packet.playersLength());
    	
    	for(int i = 0; i < packet.playersLength(); i++) {
    		allCars.add(new Car(packet.players(i)));
    	}
    	
    	this.car = allCars.get(playerIndex);
    }
    
}
