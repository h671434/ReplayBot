package replaybot.data.replay.attribute;

public sealed interface ProductValue {
	
    record NoColor() implements ProductValue {}
    record Absent() implements ProductValue {}
    record OldColor(int value) implements ProductValue {}
    record NewColor(int value) implements ProductValue {}
    record OldPaint(int value) implements ProductValue {}
    record NewPaint(int value) implements ProductValue {}
    record Title(String value) implements ProductValue {}
    record SpecialEdition(int value) implements ProductValue {}
    record OldTeamEdition(int value) implements ProductValue {}
    record NewTeamEdition(int value) implements ProductValue {}
    
}

