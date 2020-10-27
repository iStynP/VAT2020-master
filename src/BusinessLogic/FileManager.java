package BusinessLogic;

import Domain.ShapeHolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private FileWriter writer;
    private ShapeHolder shapeHolder;
    private Scanner reader;

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

    public void readFromFile(String filename) {
        File file = new File( filename );
        this.reader = null;

        try {
            reader = new Scanner( file );
        } catch (FileNotFoundException e) {
            System.out.println("Opening file failed :" + e.getMessage());
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            //make line into new Shape-Object
//            System.out.println(line);
            shapeHolder.addToListFromFile( line );
        }

        reader.close();

    }
}
