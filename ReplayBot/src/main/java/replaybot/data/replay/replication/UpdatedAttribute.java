package replaybot.data.replay.replication;

import replaybot.data.replay.CompressedWord;
import replaybot.data.replay.attribute.AppliedDamage;
import replaybot.data.replay.attribute.Attribute;
import replaybot.data.replay.attribute.CustomDemolish;

public class UpdatedAttribute {
	
	private CompressedWord id;
	private String name;
	private Attribute attribute;
	
	public UpdatedAttribute(CompressedWord id, String name, Attribute attribute) {
		this.id = id;
		this.name = name;
		this.attribute = attribute;
	}
	
}
