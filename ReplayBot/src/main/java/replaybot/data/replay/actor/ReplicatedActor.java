package replaybot.data.replay.actor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import replaybot.data.replay.attribute.Attribute;

public abstract class ReplicatedActor {
	
	public abstract void setField(String field, Attribute attribute) throws ClassCastException;
	
}
