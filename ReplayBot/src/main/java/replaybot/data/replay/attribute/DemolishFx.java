package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import replaybot.math.Vector3;

public class DemolishFx {
	
    private final boolean customDemoFlag;
    private final int customDemoId;
    private final boolean attackerFlag;
    private final int attacker;
    private final boolean victimFlag;
    private final int victim;
    private final Vector3 attackVelocity;
    private final Vector3 victimVelocity;

    @JsonCreator
    public DemolishFx(
    		@JsonProperty("custom_demo_flag") boolean customDemoFlag,
    		@JsonProperty("custom_demo_id") int customDemoId,
    		@JsonProperty("attacker_flag") boolean attackerFlag,
    		@JsonProperty("attacker") int attacker,
    		@JsonProperty("victim_flag") boolean victimFlag,
    		@JsonProperty("victim") int victim,
    		@JsonProperty("attack_velocity") Vector3 attackVelocity,
    		@JsonProperty("victim_velocity") Vector3 victimVelocity) {
        this.customDemoFlag = customDemoFlag;
        this.customDemoId = customDemoId;
        this.attackerFlag = attackerFlag;
        this.attacker = attacker;
        this.victimFlag = victimFlag;
        this.victim = victim;
        this.attackVelocity = attackVelocity;
        this.victimVelocity = victimVelocity;
    }

    public boolean isCustomDemoFlag() {
        return customDemoFlag;
    }

    public int getCustomDemoId() {
        return customDemoId;
    }

    public boolean isAttackerFlag() {
        return attackerFlag;
    }

    public int getAttacker() {
        return attacker;
    }

    public boolean isVictimFlag() {
        return victimFlag;
    }

    public int getVictim() {
        return victim;
    }

    public Vector3 getAttackVelocity() {
        return attackVelocity;
    }

    public Vector3 getVictimVelocity() {
        return victimVelocity;
    }

}

