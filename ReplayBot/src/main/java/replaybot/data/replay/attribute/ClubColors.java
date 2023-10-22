package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClubColors {

	private final boolean blueFlag;
	private final int blueColor;
	private final boolean orangeFlag;
	private final int orangeColor;
	
	@JsonCreator
	public ClubColors(
			@JsonProperty("blue_flag") boolean blueFlag,
			@JsonProperty("blue_color") int blueColor,
			@JsonProperty("orange_flag") boolean orangeFlag,
			@JsonProperty("orange_color") int orangeColor) {
    	this.blueFlag = blueFlag;
    	this.blueColor = blueColor;
    	this.orangeFlag = orangeFlag;
    	this.orangeColor = orangeColor;
    }

	public boolean isBlueFlag() {
		return blueFlag;
	}

	public int getBlueColor() {
		return blueColor;
	}

	public boolean isOrangeFlag() {
		return orangeFlag;
	}

	public int getOrangeColor() {
		return orangeColor;
	}
	
}
