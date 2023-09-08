package replaybot.data.replay.actor;

import replaybot.data.RigidBody;

public class ActorUpdateProperty<T> {

	private final String name;
	private final T value;
	
	public ActorUpdateProperty(String name, T value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<?> getType() {
		return value.getClass();
	}
	
	public boolean isClass(Class<?> c) {
		return getType() == c;
	}
	
	public boolean isByte() {
		return isClass(Byte.class);
	}
	
	public Byte getByte() {
		return (Byte) value;
	}
	
	public boolean isInt() {
		return isClass(Integer.class);
	}
	
	public Integer getInt() {
		return (Integer) value;
	}
	
	public boolean isDouble() {
		return isClass(Double.class);
	}
	
	public Double getDouble() {
		return (Double) value;
	}
	
	public boolean isBoolean() {
		return isClass(Boolean.class);
	}
	
	public Boolean getBoolean() {
		return (Boolean) value;
	}
	
	public boolean isRigidBody() {
		return isClass(RigidBody.class);
	}
	
	public RigidBody getRigidBody() {
		return (RigidBody) value;
	}
	
}
