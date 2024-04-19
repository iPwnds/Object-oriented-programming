//package StudentTests;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
//import sim.naturalselection.BorderHabitableZone;
//import sim.Creature;
//import sim.World;
//import util.Point;
//
//public class BorderHabitableZoneTest {
//    private BorderHabitableZone borderZone;
//
//    @BeforeEach
//    public void setUp() {
//        borderZone = new BorderHabitableZone(2); // Create a border zone of size 2
//    }
//
//    @Test
//    public void testSurvivesInsideBorderZone() {
//        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
//        Point position = new Point(3, 3); // Inside the border zone
//        //assertTrue(borderZone.survives(world, position));
//    }
//
//    @Test
//    public void testSurvivesOnBorder() {
//        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
//        Point position = new Point(2, 3); // On the border zone
//        //assertTrue(borderZone.survives(world, position));
//    }
//
//    @Test
//    public void testSurvivesOutsideBorderZone() {
//        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
//        Point position = new Point(5, 5); // Outside the border zone
//        assertFalse(borderZone.survives(world, position));
//    }
//
//    @Test
//    public void testSurvivesAtCorner() {
//        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
//        Point position = new Point(0, 0); // At the corner
//        assertTrue(borderZone.survives(world, position));
//    }
//
//    @Test
//    public void testSurvivesAtEdge() {
//        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
//        Point position = new Point(9, 9); // At the edge (opposite corner)
//        assertTrue(borderZone.survives(world, position));
//    }
//
//    @Test
//    public void testNullWorld() {
//        Point position = new Point(3, 3); // Inside the border zone
//        assertThrows(NullPointerException.class, () -> {
//            borderZone.survives(null, position);
//        });
//    }
//
//    @Test
//    public void testNullPosition() {
//        World world = new World(10, 10, new Creature[0]); // Create a 10x10 world
//        assertThrows(NullPointerException.class, () -> {
//            borderZone.survives(world, null);
//        });
//    }
//}
