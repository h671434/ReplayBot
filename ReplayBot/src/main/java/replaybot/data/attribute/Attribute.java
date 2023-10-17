package replaybot.data.attribute;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.storage.AttributeDeserializer;
import replaybot.math.Rotation;

@JsonDeserialize(using = AttributeDeserializer.class)
public sealed interface Attribute {
	
	record ByteAttribute(byte value) implements Attribute {}
	record BooleanAttribute(boolean value) implements Attribute {}
	record IntAttribute(int value) implements Attribute {}
	record FloatAttribute(float value) implements Attribute {}
	record StringAttribute(String value) implements Attribute {}
	record RotationAttribute(Rotation value) implements Attribute {}
	record ActiveActorAttribute(ActiveActor value) implements Attribute {}
	record RigidBodyAttribute(RigidBody value) implements Attribute {}
	record DemolishAttribute(Demolish value) implements Attribute {}
	
	record NotImplementedAttribute() implements Attribute {}
	
}
