package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamPaint {
    private final int team;
    private final int primaryColor;
    private final int accentColor;
    private final long primaryFinish;
    private final long accentFinish;

    @JsonCreator
    public TeamPaint(
    		@JsonProperty("team") int team,
    		@JsonProperty("primary_color") int primaryColor,
    		@JsonProperty("accent_color") int accentColor,
    		@JsonProperty("primary_finish") long primaryFinish,
    		@JsonProperty("accent_finish") long accentFinish) {
        this.team = team;
        this.primaryColor = primaryColor;
        this.accentColor = accentColor;
        this.primaryFinish = primaryFinish;
        this.accentFinish = accentFinish;
    }

    public int getTeam() {
        return team;
    }

    public int getPrimaryColor() {
        return primaryColor;
    }

    public int getAccentColor() {
        return accentColor;
    }

    public long getPrimaryFinish() {
        return primaryFinish;
    }

    public long getAccentFinish() {
        return accentFinish;
    }
}

