package Polymorphism;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Drawing {

    private Shape[] shapes;

    public Drawing(Shape... shapes) {
        this.shapes = shapes.clone();
    }

    public String toSVG() {
        String svg = "<svg xmlns='http://www.w3.org/2000/svg'"
                     + " stroke='black' fill='transparent'>";
        for (Shape shape : shapes) {
        	
        	
//        	if (shape instanceof Circle circle)
//                svg += "<circle cx='" + circle.getX() + "' cy='" + circle.getY() + "' r='" + circle.getRadius() + "'/>";
        	
        	
            if (shape instanceof Circle) {
                Circle circle = (Circle)shape;
                svg += "<circle cx='" + circle.getX()
                       + "' cy='" + circle.getY()
                       + "' r='" + circle.getRadius()
                       + "'/>";
            } else {
                Polygon polygon = (Polygon)shape;
                svg += "<polygon points='";
                for (int k = 0; k < polygon.getNbVertices(); k++)
                    svg += polygon.getX(k) + " " + polygon.getY(k) + " ";
                svg += "'/>";
            }
        }
        return svg + "</svg>";
    }

    public void saveAsSVG(String filename) throws Exception {
        Files.writeString(
            new File(filename + ".svg").toPath(),
            toSVG(),
            StandardCharsets.UTF_8);
    }
    
    public static void main(String[] args) throws Exception {
    	Drawing drawing = new Drawing(
    	    new Polygon(0, 0, 300, 0, 150, 200),
    	    new Circle(150, 100, 80)
    	);
    	drawing.saveAsSVG("drawing");
    }

}
