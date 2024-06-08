package Interfaces;

public class BooleanType extends Type implements AndableType {
    private BooleanType() {}
    public static final BooleanType INSTANCE = new BooleanType();
    
    public Value and(Value leftOperand, Value rightOperand) {
        return BooleanValue.of(((BooleanValue)leftOperand).value
            & ((BooleanValue)rightOperand).value);
    }
}