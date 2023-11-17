package replaybot.replay.summary.playerstats;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerBoostStats {
	
    @JsonProperty("bpm")
    private int bpm;

    @JsonProperty("bcpm")
    private float bcpm;

    @JsonProperty("avg_amount")
    private float avgAmount;

    @JsonProperty("amount_collected")
    private int amountCollected;

    @JsonProperty("amount_stolen")
    private int amountStolen;

    @JsonProperty("amount_collected_big")
    private int amountCollectedBig;

    @JsonProperty("amount_stolen_big")
    private int amountStolenBig;

    @JsonProperty("amount_collected_small")
    private int amountCollectedSmall;

    @JsonProperty("amount_stolen_small")
    private int amountStolenSmall;

    @JsonProperty("count_collected_big")
    private int countCollectedBig;

    @JsonProperty("count_stolen_big")
    private int countStolenBig;

    @JsonProperty("count_collected_small")
    private int countCollectedSmall;

    @JsonProperty("count_stolen_small")
    private int countStolenSmall;

    @JsonProperty("amount_overfill")
    private int amountOverfill;

    @JsonProperty("amount_overfill_stolen")
    private int amountOverfillStolen;

    @JsonProperty("amount_used_while_supersonic")
    private int amountUsedWhileSupersonic;

    @JsonProperty("time_zero_boost")
    private float timeZeroBoost;

    @JsonProperty("percent_zero_boost")
    private float percentZeroBoost;

    @JsonProperty("time_full_boost")
    private float timeFullBoost;

    @JsonProperty("percent_full_boost")
    private float percentFullBoost;

    @JsonProperty("time_boost_0_25")
    private float timeBoost0to25;

    @JsonProperty("time_boost_25_50")
    private float timeBoost25to50;

    @JsonProperty("time_boost_50_75")
    private float timeBoost50to75;

    @JsonProperty("time_boost_75_100")
    private float timeBoost75to100;

    @JsonProperty("percent_boost_0_25")
    private float percentBoost0to25;

    @JsonProperty("percent_boost_25_50")
    private float percentBoost25to50;

    @JsonProperty("percent_boost_50_75")
    private float percentBoost50to75;

    @JsonProperty("percent_boost_75_100")
    private float percentBoost75to100;

    public PlayerBoostStats() {}

	public PlayerBoostStats(int bpm, float bcpm, float avgAmount, int amountCollected, int amountStolen,
			int amountCollectedBig, int amountStolenBig, int amountCollectedSmall, int amountStolenSmall,
			int countCollectedBig, int countStolenBig, int countCollectedSmall, int countStolenSmall,
			int amountOverfill, int amountOverfillStolen, int amountUsedWhileSupersonic, float timeZeroBoost,
			float percentZeroBoost, float timeFullBoost, float percentFullBoost, float timeBoost0to25,
			float timeBoost25to50, float timeBoost50to75, float timeBoost75to100, float percentBoost0to25,
			float percentBoost25to50, float percentBoost50to75, float percentBoost75to100) {
		this.bpm = bpm;
		this.bcpm = bcpm;
		this.avgAmount = avgAmount;
		this.amountCollected = amountCollected;
		this.amountStolen = amountStolen;
		this.amountCollectedBig = amountCollectedBig;
		this.amountStolenBig = amountStolenBig;
		this.amountCollectedSmall = amountCollectedSmall;
		this.amountStolenSmall = amountStolenSmall;
		this.countCollectedBig = countCollectedBig;
		this.countStolenBig = countStolenBig;
		this.countCollectedSmall = countCollectedSmall;
		this.countStolenSmall = countStolenSmall;
		this.amountOverfill = amountOverfill;
		this.amountOverfillStolen = amountOverfillStolen;
		this.amountUsedWhileSupersonic = amountUsedWhileSupersonic;
		this.timeZeroBoost = timeZeroBoost;
		this.percentZeroBoost = percentZeroBoost;
		this.timeFullBoost = timeFullBoost;
		this.percentFullBoost = percentFullBoost;
		this.timeBoost0to25 = timeBoost0to25;
		this.timeBoost25to50 = timeBoost25to50;
		this.timeBoost50to75 = timeBoost50to75;
		this.timeBoost75to100 = timeBoost75to100;
		this.percentBoost0to25 = percentBoost0to25;
		this.percentBoost25to50 = percentBoost25to50;
		this.percentBoost50to75 = percentBoost50to75;
		this.percentBoost75to100 = percentBoost75to100;
	}

	public int getBpm() {
		return bpm;
	}

	public float getBcpm() {
		return bcpm;
	}

	public float getAvgAmount() {
		return avgAmount;
	}

	public int getAmountCollected() {
		return amountCollected;
	}

	public int getAmountStolen() {
		return amountStolen;
	}

	public int getAmountCollectedBig() {
		return amountCollectedBig;
	}

	public int getAmountStolenBig() {
		return amountStolenBig;
	}

	public int getAmountCollectedSmall() {
		return amountCollectedSmall;
	}

	public int getAmountStolenSmall() {
		return amountStolenSmall;
	}

	public int getCountCollectedBig() {
		return countCollectedBig;
	}

	public int getCountStolenBig() {
		return countStolenBig;
	}

	public int getCountCollectedSmall() {
		return countCollectedSmall;
	}

	public int getCountStolenSmall() {
		return countStolenSmall;
	}

	public int getAmountOverfill() {
		return amountOverfill;
	}

	public int getAmountOverfillStolen() {
		return amountOverfillStolen;
	}

	public int getAmountUsedWhileSupersonic() {
		return amountUsedWhileSupersonic;
	}

	public float getTimeZeroBoost() {
		return timeZeroBoost;
	}

	public float getPercentZeroBoost() {
		return percentZeroBoost;
	}

	public float getTimeFullBoost() {
		return timeFullBoost;
	}

	public float getPercentFullBoost() {
		return percentFullBoost;
	}

	public float getTimeBoost0to25() {
		return timeBoost0to25;
	}

	public float getTimeBoost25to50() {
		return timeBoost25to50;
	}

	public float getTimeBoost50to75() {
		return timeBoost50to75;
	}

	public float getTimeBoost75to100() {
		return timeBoost75to100;
	}

	public float getPercentBoost0to25() {
		return percentBoost0to25;
	}

	public float getPercentBoost25to50() {
		return percentBoost25to50;
	}

	public float getPercentBoost50to75() {
		return percentBoost50to75;
	}

	public float getPercentBoost75to100() {
		return percentBoost75to100;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountCollected, amountCollectedBig, amountCollectedSmall, amountOverfill,
				amountOverfillStolen, amountStolen, amountStolenBig, amountStolenSmall, amountUsedWhileSupersonic,
				avgAmount, bcpm, bpm, countCollectedBig, countCollectedSmall, countStolenBig, countStolenSmall,
				percentBoost0to25, percentBoost25to50, percentBoost50to75, percentBoost75to100, percentFullBoost,
				percentZeroBoost, timeBoost0to25, timeBoost25to50, timeBoost50to75, timeBoost75to100, timeFullBoost,
				timeZeroBoost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PlayerBoostStats other = (PlayerBoostStats) obj;
		
		return amountCollected == other.amountCollected && amountCollectedBig == other.amountCollectedBig
				&& amountCollectedSmall == other.amountCollectedSmall && amountOverfill == other.amountOverfill
				&& amountOverfillStolen == other.amountOverfillStolen && amountStolen == other.amountStolen
				&& amountStolenBig == other.amountStolenBig && amountStolenSmall == other.amountStolenSmall
				&& amountUsedWhileSupersonic == other.amountUsedWhileSupersonic
				&& Float.floatToIntBits(avgAmount) == Float.floatToIntBits(other.avgAmount)
				&& Float.floatToIntBits(bcpm) == Float.floatToIntBits(other.bcpm) && bpm == other.bpm
				&& countCollectedBig == other.countCollectedBig && countCollectedSmall == other.countCollectedSmall
				&& countStolenBig == other.countStolenBig && countStolenSmall == other.countStolenSmall
				&& Float.floatToIntBits(percentBoost0to25) == Float.floatToIntBits(other.percentBoost0to25)
				&& Float.floatToIntBits(percentBoost25to50) == Float.floatToIntBits(other.percentBoost25to50)
				&& Float.floatToIntBits(percentBoost50to75) == Float.floatToIntBits(other.percentBoost50to75)
				&& Float.floatToIntBits(percentBoost75to100) == Float.floatToIntBits(other.percentBoost75to100)
				&& Float.floatToIntBits(percentFullBoost) == Float.floatToIntBits(other.percentFullBoost)
				&& Float.floatToIntBits(percentZeroBoost) == Float.floatToIntBits(other.percentZeroBoost)
				&& Float.floatToIntBits(timeBoost0to25) == Float.floatToIntBits(other.timeBoost0to25)
				&& Float.floatToIntBits(timeBoost25to50) == Float.floatToIntBits(other.timeBoost25to50)
				&& Float.floatToIntBits(timeBoost50to75) == Float.floatToIntBits(other.timeBoost50to75)
				&& Float.floatToIntBits(timeBoost75to100) == Float.floatToIntBits(other.timeBoost75to100)
				&& Float.floatToIntBits(timeFullBoost) == Float.floatToIntBits(other.timeFullBoost)
				&& Float.floatToIntBits(timeZeroBoost) == Float.floatToIntBits(other.timeZeroBoost);
	}

	@Override
	public String toString() {
		return "PlayerBoostStats [bpm=" + bpm + ", bcpm=" + bcpm + ", avgAmount=" + avgAmount + ", amountCollected="
				+ amountCollected + ", amountStolen=" + amountStolen + ", amountCollectedBig=" + amountCollectedBig
				+ ", amountStolenBig=" + amountStolenBig + ", amountCollectedSmall=" + amountCollectedSmall
				+ ", amountStolenSmall=" + amountStolenSmall + ", countCollectedBig=" + countCollectedBig
				+ ", countStolenBig=" + countStolenBig + ", countCollectedSmall=" + countCollectedSmall
				+ ", countStolenSmall=" + countStolenSmall + ", amountOverfill=" + amountOverfill
				+ ", amountOverfillStolen=" + amountOverfillStolen + ", amountUsedWhileSupersonic="
				+ amountUsedWhileSupersonic + ", timeZeroBoost=" + timeZeroBoost + ", percentZeroBoost="
				+ percentZeroBoost + ", timeFullBoost=" + timeFullBoost + ", percentFullBoost=" + percentFullBoost
				+ ", timeBoost0to25=" + timeBoost0to25 + ", timeBoost25to50=" + timeBoost25to50 + ", timeBoost50to75="
				+ timeBoost50to75 + ", timeBoost75to100=" + timeBoost75to100 + ", percentBoost0to25="
				+ percentBoost0to25 + ", percentBoost25to50=" + percentBoost25to50 + ", percentBoost50to75="
				+ percentBoost50to75 + ", percentBoost75to100=" + percentBoost75to100 + "]";
	}
    
}

