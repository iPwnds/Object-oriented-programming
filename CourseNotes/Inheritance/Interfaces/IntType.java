package Interfaces;

public class IntType extends Type implements AddableType, AndableType {
	private IntType() {}
    public static final IntType INSTANCE = new IntType();
    
    public Value add(Value leftOperand, Value rightOperand) {
        return IntValue.of(((IntValue)leftOperand).value
            + ((IntValue)rightOperand).value);
    }
    
    // ERROR
    public Value and(Value leftOperand, Value rightOperand) {
//        return IntValue.of((IntValue)leftOperand).value
//            & ((IntValue)rightOperand).value);
    	return null;
    }
}