package Dynamic_binding;

public class Drawing {

    private Shape[] shapes;

	
    // ...

//    public String toSVG() {
//        String svg = "<svg xmlns='http://www.w3.org/2000/svg'"
//                     + " stroke='black' fill='transparent'>";
//        for (Shape shape : shapes)
//            if (shape instanceof Circle circle)
//                svg += circle.toSVG();
//            else
//                svg += ((Polygon)shape).toSVG();
//        return svg + "</svg>";
//    }
    
    public String toSVG() {
        String svg = "<svg xmlns='http://www.w3.org/2000/svg'"
                     + " stroke='black' fill='transparent'>";
        for (Shape shape : shapes)
            svg += shape.toSVG();
        return svg + "</svg>";
    }

}