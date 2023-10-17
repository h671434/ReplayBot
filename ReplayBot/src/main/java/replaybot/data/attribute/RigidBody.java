package replaybot.data.attribute;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import replaybot.gui.BotGUI;
import replaybot.math.Rotation;
import replaybot.math.Vector3;
import replaybot.math.Vector3;

public class RigidBody {
	
	private final Vector3 location;
	private final Rotation rotation;
	private final Vector3 linearVelocity;
	private final Vector3 angularVelocity;
	
	public RigidBody(Vector3 location, Rotation rotation, Vector3 linearVelocity,
			Vector3 angularVelocity) {
		this.location = location;
		this.rotation = rotation;
		this.linearVelocity = linearVelocity;
		this.angularVelocity = angularVelocity;
	}
	
}
