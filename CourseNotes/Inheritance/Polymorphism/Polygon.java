package Polymorphism;

public class Polygon {

    private final int[] coordinates;

    public int getNbVertices() { return coordinates.length / 2; }
    public int getX(int vertex) { return coordinates[vertex * 2]; }
    public int getY(int vertex) { return coordinates[vertex * 2 + 1]; }

    public Polygon(int... coordinates) {
        this.coordinates = coordinates.clone();
    }

}
