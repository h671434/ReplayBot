package replaybot.data.replay.attribute;

import replaybot.math.Vector3;

public class Demolish {
	
    private final boolean attackerFlag;
    private final int attacker;
    private final boolean victimFlag;
    private final int victim;
    private final Vector3 attackVelocity;
    private final Vector3 victimVelocity;

    public Demolish(boolean attackerFlag, int attacker, boolean victimFlag, int victim, 
    		Vector3 attackVelocity, Vector3 victimVelocity) {
        this.attackerFlag = attackerFlag;
        this.attacker = attacker;
        this.victimFlag = victimFlag;
        this.victim = victim;
        this.attackVelocity = attackVelocity;
        this.victimVelocity = victimVelocity;
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