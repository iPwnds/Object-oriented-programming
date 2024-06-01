package Interfaces;

public class StringType extends Type implements AddableType {
    private StringType() {}
    public static final StringType INSTANCE = new StringType();
    
    public Value add(Value leftOperand, Value rightOperand) {
        return StringValue.of(((StringValue)leftOperand).value
            + ((StringValue)rightOperand).value);
    }
}