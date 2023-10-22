package replaybot.data.replay.attribute;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import replaybot.data.replay.storage.AttributeDeserializer;

/**
 * Interface to be used similar to Rust enums using pattern matching:
 * 
 * 		if(attribute instanceof Attribute.Byte byte) {
 * 			doSomethingWithByte(byte);
 * 		}
 */
@JsonDeserialize(using = AttributeDeserializer.class)
public sealed interface Attribute {
	
	record Byte(byte value) implements Attribute {}
	record Boolean(boolean value) implements Attribute {}
	record Int(int value) implements Attribute {}
	record Float(float value) implements Attribute {}
	record String(java.lang.String value) implements Attribute {}
	record Rotation(replaybot.math.Rotation value) implements Attribute {}
	record ActiveActor(replaybot.data.replay.attribute.ActiveActor value) implements Attribute {}
	record RigidBody(replaybot.data.replay.attribute.RigidBody value) implements Attribute {}
	record NotImplemented() implements Attribute {}
	
	default byte asByte() throws IllegalArgumentException {
		if(this instanceof Attribute.Byte attribute) {
			return attribute.value;
		}
		
		throw new IllegalArgumentException("Attribute is not of type Attribute.Byte");
	}
	
	default boolean asBoolean() throws IllegalArgumentException {
		if(this instanceof Attribute.Boolean attribute) {
			return attribute.value;
		}
		
		throw new IllegalArgumentException("Attribute is not of type Attribute.Boolean");
	}
	
	default int asInt() throws IllegalArgumentException {
		if(this instanceof Attribute.Int attribute) {
			return attribute.value;
		}
		
		throw new IllegalArgumentException("Attribute is not of type Attribute.Int");
	}
	
	default float asFloat() throws IllegalArgumentException {
		if(this instanceof Attribute.Float attribute) {
			return attribute.value;
		}
		
		throw new IllegalArgumentException("Attribute is not of type Attribute.Float");
	}
	
	default java.lang.String asString() throws IllegalArgumentException {
		if(this instanceof Attribute.String attribute) {
			return attribute.value;
		}
		
		throw new IllegalArgumentException("Attribute is not of type Attribute.String");
	}
	
	default replaybot.math.Rotation asRotation() throws IllegalArgumentException {
		if(this instanceof Attribute.Rotation attribute) {
			return attribute.value;
		}
		
		throw new IllegalArgumentException("Attribute is not of type Attribute.Rotation");
	}
	
	default replaybot.data.replay.attribute.ActiveActor asActiveActor() throws IllegalArgumentException {
		if(this instanceof Attribute.ActiveActor attribute) {
			return attribute.value;
		}
		
		throw new IllegalArgumentException("Attribute is not of type Attribute.ActiveActor");
	}
	
	default replaybot.data.replay.attribute.RigidBody asRigidBody() throws IllegalArgumentException {
		if(this instanceof Attribute.RigidBody attribute) {
			return attribute.value;
		}
		
		throw new IllegalArgumentException("Attribute is not of type Attribute.RigidBody");
	}
	
	default Attribute.NotImplemented asNotImplemented() throws IllegalArgumentException {
		if(this instanceof Attribute.NotImplemented attribute) {
			return attribute;
		}
		
		throw new IllegalArgumentException("Attribute is not of type Attribute.NotImplemented");
	}
	
}
