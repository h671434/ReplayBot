package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Vector3;

public class DamageState {
	
    private final byte tileState;
    private final boolean damaged;
    private final int offender;
    private final Vector3 ballPosition;
    private final boolean directHit;
    private final boolean unknown1;

    @JsonCreator
    public DamageState(
    		@JsonProperty("tile_state") byte tileState,
    		@JsonProperty("damaged") boolean damaged,
    		@JsonProperty("offender") int offender,
    		@JsonProperty("ball_position") Vector3 ballPosition,
    		@JsonProperty("direct_hit") boolean directHit,
    		@JsonProperty("unknown1") boolean unknown1) {
        this.tileState = tileState;
        this.damaged = damaged;
        this.offender = offender;
        this.ballPosition = ballPosition;
        this.directHit = directHit;
        this.unknown1 = unknown1;
    }

    public byte getTileState() {
        return tileState;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public int getOffender() {
        return offender;
    }

    public Vector3 getBallPosition() {
        return ballPosition;
    }

    public boolean isDirectHit() {
        return directHit;
    }

    public boolean isUnknown1() {
        return unknown1;
    }
    
}
