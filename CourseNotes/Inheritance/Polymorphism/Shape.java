package Polymorphism;

import static org.junit.jupiter.api.Assertions.*;

public abstract class Shape {

	Shape shape1 = new Circle(5, 10, 5);
	Shape shape2 = new Polygon(-10, 0, 10, 0, 0, 20);

	Shape[] shapes = {new Circle(5, 10, 5), new Polygon(-10, 0, 10, 0, 0, 20)};

	
//	Shape myShape = new Circle(5, 10, 5);
//	Circle myCircle = myShape;
//	int radius = myCircle.getRadius();

	
	void Test() {
		assertEquals(true, shape1 instanceof Circle);
		assertEquals(true, shape2 instanceof Polygon);
		assertEquals(false, shape1 instanceof Polygon);
		assertEquals(false, shape2 instanceof Circle);
	}
}
