package replaybot.data.replay.attribute;

public sealed interface Attribute {

	record AppliedDamageAttribute(AppliedDamage value) implements Attribute {}
	
	record BooleanAttribute(boolean value) implements Attribute {}
	
	record ByteAttribute(byte value) implements Attribute {}
	
	record CamSettingsAttribute(CamSettings value) implements Attribute {}
	
	record ClubColorsAttribute(ClubColors value) implements Attribute {}
	
	record CustomDemolishAttribute(CustomDemolish value) implements Attribute {}
	
	record DamageStateAttribute(DamageState value) implements Attribute {}
	
	record DemolishAttribute(Demolish value) implements Attribute {}
	
	record EnumAttribute(int value) implements Attribute {}
	
	record ExplosionAttribute(Explosion value) implements Attribute {}
	
	record ExtendedExplosionAttribute(ExtendedExplosion value) implements Attribute {}
	
	record FlaggedIntAttribute(FlaggedInt value) implements Attribute {}
	
	record FlaggedByteAttribute(FlaggedByte value) implements Attribute {}
	
	record FloatAttribute(float value) implements Attribute {}
	
	record GameModeAttribute(GameMode value) implements Attribute {}
	
	record GameServerAttribute(GameServer value) implements Attribute {}
	
	record IntAttribute(int value) implements Attribute {}
	
	record LongAttribute(long value) implements Attribute {}
	
	record LoadoutAttribute(Loadout value) implements Attribute {}
	
	record LoadoutOnlineAttribute(LoadoutOnline value) implements Attribute {}
	
	record LoadoutsAttribute(Loadouts value) implements Attribute {}
	
	record LoadoutsOnlineAttribute(LoadoutsOnline value) implements Attribute {}
	
	record LocationAttribute(Location value) implements Attribute {}
	
	record MusicStingerAttribute(MusicStinger value) implements Attribute {}
	
	record PartyLeaderAttribute(PartyLeader value) implements Attribute {}
	
	record PickupAttribute(Pickup value) implements Attribute {}
	
	record PickupInfoAttribute(PickupInfo value) implements Attribute {}
	
	record PickupNewAttribute(PickupNew value) implements Attribute {}
	
	record PlayerHistoryKeyAttribute(PlayerHistoryKey value) implements Attribute {}
	
	record PrivateMatchSettingsAttribute(PrivateMatchSettings value) implements Attribute {}
	
	record QWordAttribute(QWord value) implements Attribute {}
	
	record RepStatTitleAttribute(RepStatTitle value) implements Attribute {}
	
	record ReservationAttribute(Reservation value) implements Attribute {}
	
	record RigidBodyStateAttribute(RigidBodyState value) implements Attribute {}
	
	record RotationAttribute(Rotation value) implements Attribute {}
	
	record StatEventAttribute(StatEvent value) implements Attribute {}
	
	record StringAttribute(String value) implements Attribute {}
	
	record TeamPaintAttribute(TeamPaint value) implements Attribute {}
	
	record TitleAttribute(Title value) implements Attribute {}
	
	record UniqueIdAttribute(UniqueId value) implements Attribute {}
	
	record WeldedInfoAttribute(WeldedInfo value) implements Attribute {}

}

