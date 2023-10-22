package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.data.replay.CompressedWord;
import replaybot.math.Vector3;

public class AppliedDamage {

	private final int id;
    private final Vector3 position;
    private final int damageIndex;
    private final int totalDamage;
    
	public AppliedDamage(
			@JsonProperty("unknown1") int id, 
			@JsonProperty("location") Vector3 position, 
			@JsonProperty("unknown2") int damageIndex, 
			@JsonProperty("unknown3") int totalDamage) {
		this.id = id;
		this.position = position;
		this.damageIndex = damageIndex;
		this.totalDamage = totalDamage;
	}

	public int getAppliedDamageId() {
		return id;
	}

	public Vector3 getPosition() {
		return position;
	}

	public int getDamageIndex() {
		return damageIndex;
	}

	public int getTotalDamage() {
		return totalDamage;
	}
    
}
