package BusinessLogic;

import Domain.ShapeHolder;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    FileWriter writer;
    ShapeHolder shapeHolder;

    public FileManager(ShapeHolder shapeHolder) {
        this.shapeHolder = shapeHolder;
    }

    public void writeToFile(String filename) {
        try {
            writer = new FileWriter( filename + ".txt", true );
        } catch (
                IOException e) {
            System.out.println( "An error occured: " + e.getMessage() );
        }

        try {
            writer.write( shapeHolder.print() );
        } catch (IOException e) {
            System.out.println( "An error occured: " + e.getMessage() );
        }

        try {
            writer.write( shapeHolder.printAllShapes() );
        } catch (IOException e) {
            System.out.println( "An error occured: " + e.getMessage() );
        }

        try {
            writer.close();
        } catch (IOException e) {
            System.out.println( "An error occured: " + e.getMessage() );
        }
    }
}
