package CircleHitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class Point {
	
	public final int x;
	public final int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

class Circle {
	
	public final Point center;
	public final int radius;
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

}

abstract class CircleHitTest {
	
	/**
	 * @pre | circle != null
	 * @pre | point != null
	 * 
	 * @post | Math.abs(circle.center.x - point.x) < circle.radius &&
	 *		 | Math.abs(circle.center.y - point.y) < circle.radius ?
	 *       |     Math.pow(point.x - circle.center.x, 2) +
	 *       |     Math.pow(point.y - circle.center.y, 2) <
	 *       |     Math.pow(circle.radius, 2) ?
	 *       |         result == true
	 *       |     :
	 *       |         true
	 *       | :
	 *       |     result == false
	 * 
	 * @post | Math.abs(circle.center.x - point.x) < circle.radius &&
	 *		 | Math.abs(circle.center.y - point.y) < circle.radius ||
	 *       | result == false
	 * @post | !(
	 *       |     Math.pow(point.x - circle.center.x, 2) +
	 *       |     Math.pow(point.y - circle.center.y, 2) <
	 *       |     Math.pow(circle.radius, 2)
	 *       | ) || result == true
	 */
	public abstract boolean containsPoint(Circle circle, Point point);

}

class PreciseCircleHitTest extends CircleHitTest {
	
	/**
	 * @throws IllegalArgumentException | circle == null
	 * @throws IllegalArgumentException | point == null
	 * 
	 * @post | result == (
	 *       |     Math.pow(point.x - circle.center.x, 2) +
	 *       |     Math.pow(point.y - circle.center.y, 2) <
	 *       |     Math.pow(circle.radius, 2)
	 *       | )
	 */
	@Override
	public boolean containsPoint(Circle circle, Point point) {
		if (circle == null)
			throw new IllegalArgumentException("`circle` is null");
		if (point == null)
			throw new IllegalArgumentException("`point` is null");
		
		int x = point.x - circle.center.x;
		int y = point.y - circle.center.y;
		return x * x + y * y < circle.radius * circle.radius;
	}

}

class FastCircleHitTest extends CircleHitTest {
	
	/**
	 * @pre | circle != null
	 * @pre | point != null
	 * 
	 * @post | result == (
	 *       |     Math.abs(circle.center.x - point.x) < circle.radius &&
	 *		 |     Math.abs(circle.center.y - point.y) < circle.radius
	 *		 | )
	 */
	@Override
	public boolean containsPoint(Circle circle, Point point) {
		assert circle != null;
		assert point != null;
		
		return Math.abs(circle.center.x - point.x) < circle.radius &&
				Math.abs(circle.center.y - point.y) < circle.radius;
	}

}

class CircleHitTestTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}