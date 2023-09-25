package replaybot.data.replay.gameobject;

public class Vehicle_TA {

	private byte ReplicatedThrottle;
	private byte ReplicatedSteer;
	private boolean bReplicatedHandbrake;
	private boolean bDriving;
	private boolean bPodiumMode;

	public byte getReplicatedThrottle() {
		return ReplicatedThrottle;
	}

	public void setReplicatedThrottle(byte replicatedThrottle) {
		ReplicatedThrottle = replicatedThrottle;
	}

	public byte getReplicatedSteer() {
		return ReplicatedSteer;
	}

	public void setReplicatedSteer(byte replicatedSteer) {
		ReplicatedSteer = replicatedSteer;
	}

	public boolean isbReplicatedHandbrake() {
		return bReplicatedHandbrake;
	}

	public void setbReplicatedHandbrake(boolean bReplicatedHandbrake) {
		this.bReplicatedHandbrake = bReplicatedHandbrake;
	}

	public boolean isbDriving() {
		return bDriving;
	}

	public void setbDriving(boolean bDriving) {
		this.bDriving = bDriving;
	}

	public boolean isbPodiumMode() {
		return bPodiumMode;
	}

	public void setbPodiumMode(boolean bPodiumMode) {
		this.bPodiumMode = bPodiumMode;
	}
	
}