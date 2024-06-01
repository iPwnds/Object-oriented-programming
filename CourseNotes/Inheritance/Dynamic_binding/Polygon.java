package Dynamic_binding;

public class Polygon extends Shape {

    private int[] coordinates;
	
    // ...

    public String toSVG() {
        String svg = "<polygon points='";
        for (int coord : coordinates)
            svg += coord + " ";
        return svg + "'/>";
    }

}