package Interfaces;

public class IntValue extends Value {
    public final int value;
    public Type getType() { return IntType.INSTANCE; }
    private IntValue(int value) { this.value = value; }
    public final static IntValue ZERO = new IntValue(0);
    public static IntValue of(int value) {
        return value == 0 ? ZERO : new IntValue(value);
    }
}