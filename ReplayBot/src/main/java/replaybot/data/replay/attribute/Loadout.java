package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Loadout {
	
    private final byte version;
    private final int body;
    private final int decal;
    private final int wheels;
    private final int rocketTrail;
    private final int antenna;
    private final int topper;
    private final int unknown1;
    private final int unknown2;
    private final int engineAudio;
    private final int trail;
    private final int goalExplosion;
    private final int banner;
    private final int productId;

    @JsonCreator
    public Loadout(
    		@JsonProperty("version") byte version, 
    		@JsonProperty("body") int body, 
    		@JsonProperty("decal") int decal, 
    		@JsonProperty("wheels") int wheels, 
    		@JsonProperty("rocket_trail") int rocketTrail, 
    		@JsonProperty("antenna") int antenna, 
    		@JsonProperty("topper") int topper, 
    		@JsonProperty("unknown1") int unknown1, 
    		@JsonProperty("unknown2") int unknown2, 
    		@JsonProperty("engine_audio") int engineAudio, 
    		@JsonProperty("trail") int trail, 
    		@JsonProperty("goal_explosion") int goalExplosion,
    		@JsonProperty("banner") int banner, 
    		@JsonProperty("product_id") int productId) {
    	this.version = version;
        this.body = body;
        this.decal = decal;
        this.wheels = wheels;
        this.rocketTrail = rocketTrail;
        this.antenna = antenna;
        this.topper = topper;
        this.unknown1 = unknown1;
        this.unknown2 = unknown2;
        this.engineAudio = engineAudio;
        this.trail = trail;
        this.goalExplosion = goalExplosion;
        this.banner = banner;
        this.productId = productId;
    }

    public byte getVersion() {
        return version;
    }

    public int getBody() {
        return body;
    }

    public int getDecal() {
        return decal;
    }

    public int getWheels() {
        return wheels;
    }

    public int getRocketTrail() {
        return rocketTrail;
    }

    public int getAntenna() {
        return antenna;
    }

    public int getTopper() {
        return topper;
    }

    public int getUnknown1() {
        return unknown1;
    }

    public int getUnknown2() {
        return unknown2;
    }

    public int getEngineAudio() {
        return engineAudio;
    }

    public int getTrail() {
        return trail;
    }

    public int getGoalExplosion() {
        return goalExplosion;
    }

    public int getBanner() {
        return banner;
    }

    public int getProductId() {
        return productId;
    }
}

