package replaybot.data.replay.actor;

public class CarComponentBoostTA extends CarComponentAirActivateTA {
    private float rechargeDelay;
    private boolean unlimitedBoost;
    private int unlimitedBoostRefCount;
    private boolean noBoost;
    private byte replicatedBoostAmount;
    private float rechargeRate;
    private float boostModifier;
    
    // Unused fields
    private float startBoostAmount;
    private float currentBoostAmount;
    private boolean rechargeGroundOnly;
}
