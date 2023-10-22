package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public sealed interface RemoteId {
	
    record PlayStation(Ps4Id value) implements RemoteId {}
    record PsyNet(PsyNetId value) implements RemoteId {}
    record SplitScreen(int value) implements RemoteId {}
    record Steam(long value) implements RemoteId {}
    record Switch(SwitchId value) implements RemoteId {}
    record Xbox(long value) implements RemoteId {}
    record QQ(long value) implements RemoteId {}
    record Epic(String value) implements RemoteId {}
    
    

}
