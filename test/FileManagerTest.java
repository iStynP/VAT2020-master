import BusinessLogic.FileManager;
import Domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.io.TempDir;

class FileManagerTest {
    private static FileManager fileManager;
    private static ShapeHolder shapeHolder;


    @BeforeEach
    void beforeEach() {
        shapeHolder = new ShapeHolder();
        fileManager = new FileManager( shapeHolder );
    }

    @Test
    void readFromFile_InsertTXT_and_put_it_into_shapeList() {
        try {
            fileManager.readFromFile( "circlesTest.txt" );
        }catch (Exception e) {
            System.out.println("Gaat niet: " + e.getMessage() );
        }
    }
    }
