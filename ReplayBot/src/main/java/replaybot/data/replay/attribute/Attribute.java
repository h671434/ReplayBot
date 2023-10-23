package replaybot.data.replay.attribute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import replaybot.math.Vector3;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = Attribute.NotImplementedAttribute.class)
@JsonSubTypes({
	@Type(value = Attribute.BooleanAttribute.class),
    @Type(value = Attribute.ByteAttribute.class),
	@Type(value = Attribute.ActiveActorAttribute.class),
	@Type(value = Attribute.RigidBodyAttribute.class),
	@Type(value = Attribute.DemolishAttribute.class),
	@Type(value = Attribute.IntAttribute.class),
	@Type(value = Attribute.FloatAttribute.class),
	@Type(value = Attribute.ImpulseAttribute.class),
	@Type(value = Attribute.LoadoutAttribute.class),
	@Type(value = Attribute.PickupAttribute.class),
	@Type(value = Attribute.PickupNewAttribute.class),
	@Type(value = Attribute.PickupInfoAttribute.class),
	@Type(value = Attribute.WeldedAttribute.class),
	@Type(value = Attribute.StringAttribute.class),
	@Type(value = Attribute.LocationAttribute.class),
	@Type(value = Attribute.RotationAttribute.class),
	@Type(value = Attribute.LongAttribute.class),
	@Type(value = Attribute.StatEventAttribute.class),
	@Type(value = Attribute.NotImplementedAttribute.class)
})
public sealed interface Attribute {

	record BooleanAttribute(@JsonProperty("Boolean") boolean value) implements Attribute {}
	
	record ByteAttribute(@JsonProperty("Byte") byte value) implements Attribute {}
	
	record ActiveActorAttribute(@JsonProperty("ActiveActor") ActiveActor value) implements Attribute {}
	
	record RigidBodyAttribute(@JsonProperty("RigidBody") RigidBody value) implements Attribute {}
	
	record DemolishAttribute(@JsonProperty("Demolish") Demolish value) implements Attribute {}
	
	record IntAttribute(@JsonProperty("Int") int value) implements Attribute {}
	
	record FloatAttribute(@JsonProperty("Float") float value) implements Attribute {}
	
	record ImpulseAttribute(@JsonProperty("Impulse") Impulse value) implements Attribute {}
	
	record LoadoutAttribute(@JsonProperty("Loadout") Loadout value) implements Attribute {}
	
	record PickupAttribute(@JsonProperty("Pickup") Pickup value) implements Attribute {}
	
	record PickupNewAttribute(@JsonProperty("PickupNew") PickupNew value) implements Attribute {}
	
	record PickupInfoAttribute(@JsonProperty("PickupInfo") PickupInfo value) implements Attribute {}
	
	record WeldedAttribute(@JsonProperty("Welded") Welded value) implements Attribute {}
	
	record StringAttribute(@JsonProperty("String") String value) implements Attribute {}
	
	record LocationAttribute(@JsonProperty("Location") Vector3 value) implements Attribute {}
	
	record RotationAttribute(@JsonProperty("Rotation") Vector3 value) implements Attribute {}
	
	record LongAttribute(@JsonProperty("Int64") long value) implements Attribute {}
	
	record StatEventAttribute(@JsonProperty("StatEvent") StatEvent value) implements Attribute {}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	record NotImplementedAttribute() implements Attribute {}
	
}
