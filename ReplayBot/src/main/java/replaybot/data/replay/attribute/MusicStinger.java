package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MusicStinger {
	
    private final boolean flag;
    private final long cue; 
    private final int trigger;

    @JsonCreator
    public MusicStinger(
    		@JsonProperty("flag") boolean flag, 
    		@JsonProperty("cue") long cue, 
    		@JsonProperty("trigger") int trigger) {
        this.flag = flag;
        this.cue = cue;
        this.trigger = trigger;
    }

    public boolean isFlag() {
        return flag;
    }

    public long getCue() {
        return cue;
    }

    public int getTrigger() {
        return trigger;
    }
    
}

