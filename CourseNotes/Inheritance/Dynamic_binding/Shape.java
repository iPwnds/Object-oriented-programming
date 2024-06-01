package Dynamic_binding;


public abstract class Shape {

	Circle shape = new Circle(5, 10, 5);
	
    public abstract String toSVG();
    
    public record Circle(int x, int y, int radius) {
        public Circle {
            if (radius < 0)
                throw new IllegalArgumentException("`radius` must be nonnegative");
        }
    }
   
    String recordPatterns() {
//    	if (shape instanceof Circle circle)
//    	    return "Circle(" + circle.x + ", " + circle.y + ", " + circle.radius + ")";
    	if (shape instanceof Circle(int x, int y, int radius))
    	    return "Circle(" + x + ", " + y + ", " + radius + ")";
    	else
    		return "";
    }
    
}
