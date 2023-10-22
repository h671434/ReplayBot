package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Vector3;

public class AppliedDamage {

	private final int id;
    private final Vector3 position;
    private final int damageIndex;
    private final int totalDamage;
    
    @JsonCreator
    public AppliedDamage(
    		@JsonProperty("id") int id, 
    		@JsonProperty("position") Vector3 position, 
    		@JsonProperty("damage_index") int damageIndex, 
    		@JsonProperty("total_damage") int totalDamage) {
		this.id = id;
		this.position = position;
		this.damageIndex = damageIndex;
		this.totalDamage = totalDamage;
	}

	public int getId() {
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
