package Polymorphism;

import static org.junit.jupiter.api.Assertions.*;

public abstract class Shape {

	Shape shape1 = new Circle(5, 10, 5);
	Shape shape2 = new Polygon(-10, 0, 10, 0, 0, 20);

	Shape[] shapes = {new Circle(5, 10, 5), new Polygon(-10, 0, 10, 0, 0, 20)};
	
	Shape myShape = new Circle(5, 10, 5);
//	Circle myCircle = myShape;
	Circle myCircle = (Circle)myShape;
	int radius = myCircle.getRadius();

	void Test() {
		assertEquals(true, shape1 instanceof Circle);
		assertEquals(true, shape2 instanceof Polygon);
		assertEquals(false, shape1 instanceof Polygon);
		assertEquals(false, shape2 instanceof Circle);
		
		myShapes[0] = new Circle(10, 5, 10); // OK
		myShapes[1] = new Polygon(10, 20, 30, 40, 50, 60); // Throws ArrayStoreException
	}
	
//	Object[] shapes2 = {new Circle(5, 10, 5), new Polygon(-10, 0, 10, 0, 0, 20)};
//	Object[] shapes3 = {new Circle(5, 10, 5), new Polygon(-10, 0, 10, 0, 0, 20), "Hi!"};
//	Shape[] shapes = {new Circle(5, 10, 5), new Polygon(-10, 0, 10, 0, 0, 20), "Hi!"};
	
	Object[] values = {true, 42, 'A', 3.14};
	Object[] values2 = {
		    Boolean.valueOf(true),
		    Integer.valueOf(42),
		    Character.valueOf('A'),
		    Double.valueOf(3.14)
		};
	
	void autoBoxing() {
		int sumOfIntegers = 0;
		for (Object value : values)
		    if (value instanceof Integer i)
		        sumOfIntegers += i;
//				sumOfIntegers += i.intValue();
//				sumOfIntegers += (int)values[1];
//				sumOfIntegers += ((Integer)values[1]).intValue();
	}
	
	void Polymorphism() {
		Object o = new int[] {10, 20, 30};
		if (o instanceof int[])
		  assert ((int[])o)[2] == 30;
	}
	
	Circle[] myCircles = {new Circle(5, 10, 5), new Circle(10, 20, 10)};
	Shape[] myShapes = myCircles; // OK, Circle is a subclass of Shape
}
