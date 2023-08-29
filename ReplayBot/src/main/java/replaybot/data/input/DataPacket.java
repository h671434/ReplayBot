package replaybot.data.input;

import java.util.ArrayList;
import java.util.List;

import rlbot.flat.GameTickPacket;

public class DataPacket {
	
	public final List<CarData> allCars;
	public final CarData car;
	public final BallData ball;
	public final double time;
	
    public DataPacket(GameTickPacket packet, int playerIndex) {
    	allCars = new ArrayList<>(packet.playersLength());
    	
    	for(int i = 0; i < packet.playersLength(); i++) {
    		allCars.add(new CarData(packet.players(i)));
    	}
    	
    	this.car = allCars.get(playerIndex);
    	this.ball = new BallData(packet.ball());
    	this.time = packet.gameInfo().secondsElapsed();
    }
    
}
