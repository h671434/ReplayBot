package replaybot;

import replaybot.data.ControlsOutput;
import replaybot.data.DataPacket;
import rlbot.Bot;
import rlbot.ControllerState;
import rlbot.flat.GameTickPacket;

public class ReplayBot implements Bot {

    private final int playerIndex;

    public ReplayBot(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    @Override
    public ControllerState processInput(GameTickPacket packet) {
        if(!isValid(packet)) {
            return new ControlsOutput();
        }

        DataPacket data = new DataPacket(packet, playerIndex);

        return new ControlsOutput();
    }
    
    private boolean isValid(GameTickPacket packet) {
    	return packet.playersLength() > playerIndex 
    			|| packet.ball() != null 
    			|| packet.gameInfo().isRoundActive();
    }

    @Override
    public void retire() {
        System.out.println("Retiring sample bot " + playerIndex);
    }
    
    @Override
    public int getIndex() {
        return this.playerIndex;
    }

    
}
