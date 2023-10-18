package replaybot.data.attribute;

/**
 * Interface to be used similar to Rust enums using pattern matching:
 * 
 * 		if(attribute instanceof Attribute.Byte byte) {
 * 			doSomethingWithByte(byte);
 * 		}
 */
public sealed interface Attribute {
	
	record Byte(byte value) implements Attribute {}
	record Boolean(boolean value) implements Attribute {}
	record Int(int value) implements Attribute {}
	record Float(float value) implements Attribute {}
	record String(java.lang.String value) implements Attribute {}
	record Rotation(replaybot.math.Rotation value) implements Attribute {}
	record ActiveActor(replaybot.data.attribute.ActiveActor value) implements Attribute {}
	record RigidBody(replaybot.data.attribute.RigidBody value) implements Attribute {}
	
	record NotImplemented() implements Attribute {}
	
}
