package Dynamic_binding;

public class Circle extends Shape {

	private int x;
    private int y;
    private int radius;
	
    // ...

    public String toSVG() {
        return "<circle cx='" + x + "' cy='" + y + "' r='" + radius + "'/>";
    }
    
}