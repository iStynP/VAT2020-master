import BusinessLogic.FileManager;
import Domain.ShapeHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class FileManagerTest {
    private static FileManager fileManager;
    private static ShapeHolder shapeHolder;

// Arange
    @BeforeEach
    void beforeEach() {
        shapeHolder = new ShapeHolder();
        fileManager = new FileManager( shapeHolder );
    }
    //Act
    @Test
    void readFromFile_InsertTXT_and_put_it_into_shapeList() {
        try {
            fileManager.readFromFile( "C:\\SchoolData\\JAVA\\VAT2020-master\\test\\circlesTest.txt" );
        }catch (Exception e) {
            System.out.println("Gaat niet: " + e.getMessage() );
        }

        String actual = shapeHolder.print();

        //Assert
        assertEquals( "This shape-list contains: \ncircles: 2\n\n", actual );
    }
}

