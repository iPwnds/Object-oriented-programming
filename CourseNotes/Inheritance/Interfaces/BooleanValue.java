package Interfaces;

public class BooleanValue extends Value {
    public final boolean value;
    public Type getType() { return BooleanType.INSTANCE; }
    private BooleanValue(boolean value) { this.value = value; }
    public final static BooleanValue TRUE = new BooleanValue(true);
    public final static BooleanValue FALSE = new BooleanValue(false);
    public static BooleanValue of(boolean value) { return value ? TRUE : FALSE; }
}