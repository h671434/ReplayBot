package replaybot.data.attribute;

import replaybot.math.Vector3;

public class Demolish {
	
	private final boolean attackerFlag;
	private final int attackerActorId;
	private final boolean victimFlag;
	private final int victimActorId;
	private final Vector3 attackVelocity;
	private final Vector3 victimVelocity;
	
	public Demolish(boolean attackerFlag, int attackerActorId, boolean victimFlag, int victimActorId,
			Vector3 attackVelocity, Vector3 victimVelocity) {
		this.attackerFlag = attackerFlag;
		this.attackerActorId = attackerActorId;
		this.victimFlag = victimFlag;
		this.victimActorId = victimActorId;
		this.attackVelocity = attackVelocity;
		this.victimVelocity = victimVelocity;
	}

	public boolean isAttackerFlag() {
		return attackerFlag;
	}

	public int getAttackerActorId() {
		return attackerActorId;
	}

	public boolean isVictimFlag() {
		return victimFlag;
	}

	public int getVictimActorId() {
		return victimActorId;
	}

	public Vector3 getAttackVelocity() {
		return attackVelocity;
	}

	public Vector3 getVictimVelocity() {
		return victimVelocity;
	}
	
}
