package replaybot.data;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import replaybot.gui.BotGUI;
import replaybot.math.Vector3;

public class RigidBody {
	
	public final Vector3 location;
	public final Vector3 rotation;
	public final Vector3 linearVelocity;
	public final Vector3 angularVelocity;
	
	public RigidBody() {
		this(null, null, null, null);
	}
	
	public RigidBody(Vector3 location, Vector3 rotation, Vector3 linearVelocity,
			Vector3 angularVelocity) {
		this.location = location;
		this.rotation = rotation;
		this.linearVelocity = linearVelocity;
		this.angularVelocity = angularVelocity;
	}
	
	public RigidBody(rlbot.flat.Physics physics) {
		this.location = new Vector3(physics.location());
		this.rotation = new Vector3(physics.rotation());
		this.linearVelocity = new Vector3(physics.velocity());
		this.angularVelocity = new Vector3(physics.angularVelocity());
	}
	
}
