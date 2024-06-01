package Interfaces;

public class StringValue extends Value {
    public final String value;
    public Type getType() { return StringType.INSTANCE; }
    private StringValue(String value) { this.value = value; }
    public final static StringValue EMPTY = new StringValue("");
    public static StringValue of(String value) {
        return value.equals("") ? EMPTY : new StringValue(value);
    }
}