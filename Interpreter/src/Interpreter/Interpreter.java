package Interpreter;

interface Value {
	
	/*public static final*/ int[] x = new int[10];
	
	default boolean isZero() { return this instanceof IntValue && ((IntValue)this).value == 0; }
	
	public static Value evaluate(Value value1, char operator, Value value2) {
		switch (operator) {
		case '+':
			if (value1 instanceof AddableValue)
				return ((AddableValue)value1).add(value2);
			else
				throw new RuntimeException("Cannot apply + to these values");
		case '&':
			if (value1 instanceof AndableValue)
				return ((AndableValue)value1).and(value2);
			else
				throw new RuntimeException("Cannot apply & to these values");
		default:
			throw new RuntimeException("Operator not supported");
		}
	}
}

class IntValue implements AddableValue, AndableValue {
	
	public final int value;
	
	public IntValue(int value) {
		this.value = value;
	}
	
	@Override
	public Value add(Value other) {
		if (other instanceof IntValue)
			return new IntValue(value + ((IntValue)other).value);
		else
			throw new RuntimeException("Cannot add an int to this value.");
	}
	
	@Override
	public Value and(Value other) {
		if (other instanceof IntValue)
			return new IntValue(value & ((IntValue)other).value);
		else
			throw new RuntimeException("Cannot apply & to an int value and the given value");
	}

}

class BooleanValue implements AndableValue {
	
	public final boolean value;
	
	public BooleanValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public Value and(Value other) {
		if (other instanceof BooleanValue)
			return new BooleanValue(value & ((BooleanValue)other).value);
		else
			throw new RuntimeException("Cannot add a boolean to this value.");
	}

}

class StringValue implements AddableValue {

	public final String value;
	
	public StringValue(String value) {
		this.value = value;
	}
	
	@Override
	public Value add(Value other) {
		if (other instanceof StringValue)
			return new StringValue(value + ((StringValue)other).value);
		else
			throw new RuntimeException("Cannot add a string to this value");
	}
	
}

interface AddableValue extends Value {
	
	public abstract Value add(Value other);

}

interface AndableValue extends Value {
	
	/*public abstract*/ Value and(Value other);
	
}