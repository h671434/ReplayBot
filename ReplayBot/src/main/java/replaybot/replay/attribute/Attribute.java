package replaybot.replay.attribute;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.replay.storage.AttributeDeserializer;

@JsonDeserialize(using = AttributeDeserializer.class)
public sealed interface Attribute {
	
	record Byte(java.lang.Byte value) implements Attribute {}
	record Boolean(java.lang.Boolean value) implements Attribute {}
	record Int(java.lang.Integer value) implements Attribute {}
	record Float(java.lang.Float value) implements Attribute {}
	record String(java.lang.String value) implements Attribute {}
	record Rotation(replaybot.math.Rotation value) implements Attribute {}
	record ActiveActor(replaybot.replay.attribute.ActiveActor value) implements Attribute {}
	record RigidBody(replaybot.data.RigidBody value) implements Attribute {}
	record Demolish(replaybot.replay.attribute.Demolish value) implements Attribute {}
	
	record NotImplemented() implements Attribute {}
	
}
