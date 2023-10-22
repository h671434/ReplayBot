package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PrivateMatchSettings {
	
    private final String mutators;
    private final int joinableBy;
    private final int maxPlayers;
    private final String gameName;
    private final String password;
    private final boolean flag;

    @JsonCreator
    public PrivateMatchSettings(
    		@JsonProperty("mutators") String mutators,
    		@JsonProperty("joinable_by") int joinableBy,
    		@JsonProperty("max_players") int maxPlayers,
    		@JsonProperty("game_name") String gameName,
    		@JsonProperty("password") String password,
    		@JsonProperty("flag") boolean flag) {
        this.mutators = mutators;
        this.joinableBy = joinableBy;
        this.maxPlayers = maxPlayers;
        this.gameName = gameName;
        this.password = password;
        this.flag = flag;
    }

    public String getMutators() {
        return mutators;
    }

    public int getJoinableBy() {
        return joinableBy;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public String getGameName() {
        return gameName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isFlag() {
        return flag;
    }
}

