import Domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    private static Triangle triangle1;
    private static Sphere sphere1;
    private static Circle circle1;
    private static Block block1;
    private static Cylinder cylinder1;
    private static Square square1;

    @BeforeEach
    void beforeEach() {
        triangle1 = new Triangle( 6, 7, 8 );
        sphere1 = new Sphere( 3 );
        circle1 = new Circle( 12 );
        block1 = new Block( 2,4,6 );
        cylinder1 = new Cylinder( 12,4 );
        square1 = new Square( 3,5 );
    }

    @Test
    void square_get_surface_expected_15(){
        //Arrange
        //See beforeEach
        //Calculate volume of square with 3 length and 5 width
        double expected = 3 * 5;

        //Act
        double actual = square1.getSurface();

        //Assert
        assertEquals( expected, actual );
    }

    @Test
    void block_get_volume_expected_48() {
        //Arrange
        //See beforeEach
        //Calculate volume of block with 2 length, 4 width, 6 height
        double expected = 2 * 4 * 6;

        //Act
        double actual = block1.getVolume();

        //Assert
        assertEquals( expected, actual );
    }

    @Test
    void circle_get_perimeter_expected_75_39822368615503() {
        //Arrange
        //See beforeEach
        //Calculate perimeter of circle with a 12cm radius
        double expected = Math.PI * 2 * 12;

        //Act
        double actual = circle1.getPerimeter();

        //Assert
        assertEquals( expected, actual );
    }

    @Test
    void sphere_get_volume_expected_113_09733552923254() {
        //Arrange
        //See beforeEach
        //Calculate volume of sphere with a 3cm radius
        double expected = (4.00/3.00)*Math.PI*Math.pow( 3,3 );

        //Act
        double actual = sphere1.getVolume();

        //Assert
        assertEquals( expected, actual );
    }
}