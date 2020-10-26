import Domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeHolderTest {

    private static ShapeHolder shapeHolder;
    private static Triangle triangle1;
    private static Triangle triangle2;
    private static Triangle triangle3;
    private static Sphere sphere1;
    private static Sphere sphere2;
    private static Circle circle1;
    private static Circle circle2;
    private static Block block1;



    @BeforeEach
    void beforeEach() {
        shapeHolder = new ShapeHolder();
        triangle1 = new Triangle( 4, 5, 6 );
        triangle2 = new Triangle( 5, 6, 7 );
        triangle3 = new Triangle( 6, 7, 8 );
        sphere1 = new Sphere( 3 );
        sphere2 = new Sphere( 4 );

        shapeHolder.addShape( triangle1 );
        shapeHolder.addShape( triangle2 );
        shapeHolder.addShape( triangle3 );
        shapeHolder.addShape( triangle1 );
        shapeHolder.addShape( sphere1 );
        shapeHolder.addShape( sphere2 );
        shapeHolder.addShape( sphere1 );
    }


    @Test
    void print_shapeholder_add_7_shapes_expected_5_shapes(){
        //Arrange
        //See beforeEach
        //Add shapes to shapeholder and check amount of shapes in list


        //Act
        int actual = shapeHolder.amountOfShapes();

        //Assert
        assertEquals( 5, actual );

    }

    @Test
    void add2_and_delete1_shapes_expected_6_shapes() {
        //Assert
        //See before each
        //Add new shapes to shapeholder AND delete shapes, then check amount of shapes
        circle1 = new Circle( 5 );
        circle2 = new Circle( 6 );
        block1 = new Block( 3,5,7 );
        shapeHolder.addShape( circle1 );
        shapeHolder.addShape( circle2 );
        shapeHolder.addShape( block1 );
        shapeHolder.deleteShape( circle1 );
        shapeHolder.deleteShape( block1 );

        int expected = 6;

        //Act
        int actual = shapeHolder.amountOfShapes();

        //Assert
        assertEquals( expected, actual );
    }

    @Test
    void print_for_3triangles_and_2spheres_expect_3triangles_2spheres() {
        //Arrange
        //See beforeEach
        String expected = "This shape-list contains: " + "\ntriangles: 3" +
                "\nspheres: 2\n\n";

        //Act
        String actual = shapeHolder.print();

        //Assert
        assertEquals( expected, actual );

    }

}