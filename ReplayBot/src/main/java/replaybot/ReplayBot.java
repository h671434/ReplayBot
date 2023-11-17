package replaybot;

import replaybot.data.ControlsOutput;
import rlbot.BaseBot;
import rlbot.ControllerState;
import rlbot.flat.GameTickPacket;

public class ReplayBot extends BaseBot {

    public ReplayBot(int index, int team) {
		super(index, team);
	}

	@Override
    public ControllerState processInput(GameTickPacket packet) {
        if(!isValidPacket(packet)) {
            return new ControlsOutput();
        }

        // TODO
        
        return new ControlsOutput();
    }
    
    private boolean isValidPacket(GameTickPacket packet) {
    	return packet.playersLength() > index 
    			|| packet.ball() != null 
    			|| packet.gameInfo().isRoundActive();
    }

    @Override
    public void retire() {
        System.out.println("Retiring sample bot " + index);
    }
    

    
}
