package Interfaces;

public class Interpreter {
	@SuppressWarnings("null")
	public static Value evaluate(Value value1, char operator, Value value2) {
		
        Value leftOperand = null;
        
		Type type = leftOperand.getType();
		
        Value rightOperand = null;
        
        if (type != rightOperand.getType())
            throw new UnsupportedOperationException(
                "The operand types do not match");
        switch (operator) {
            case '+':
                if (!(type instanceof AddableType))
                    throw new UnsupportedOperationException(
                        "Type " + type + " does not support the + operator");
                return ((AddableType)type).add(value1, value2);
            case '&':
                if (!(type instanceof AndableType))
                    throw new UnsupportedOperationException(
                        "Type " + type + " does not support the & operator");
                return ((AndableType)type).and(value1, value2);
            // ...
         }
		return leftOperand;
    }
}