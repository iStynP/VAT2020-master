package BusinessLogic;

import Domain.Shape;
import Domain.ShapeHolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager implements Serializable {
    private FileWriter writer;
    private ShapeHolder shapeHolder;
    private Scanner reader;
    private Object ShapeHolder;
    private ArrayList<Shape> shapeArrayList;

    public FileManager(ShapeHolder shapeHolder) {
        this.shapeHolder = shapeHolder;
    }

    public FileManager() {

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
            System.out.println( "Opening file failed :" + e.getMessage() );
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            //make line into new Shape-Object
//            System.out.println(line);
//            shapeHolder.addToListFromFile( line );
        }

        reader.close();

    }

    public void serialization(String filename) {
        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream( filename + ".ser" );
            OutputStream buffer = new BufferedOutputStream( file );
            ObjectOutputStream out = new ObjectOutputStream( buffer );

            ArrayList<Shape> arrayListToSave = new ArrayList<>(  );
            for (int i = 0; i < this.shapeHolder.amountOfShapes(); i++) {
                arrayListToSave.add( this.shapeHolder.getShape( i ));
            }

            // Method for serialization of object
            out.writeObject( arrayListToSave );

            out.close();
            file.close();

            System.out.println( "Serialized data is saved in " + filename + ".ser" );

        } catch (
                IOException e) {
            System.out.println( "IOException is caught" );
            System.out.println(e.getMessage());
        }

    }

//    public boolean deSerializationTrue(String filename){
//        if (deSerialization( filename ) == null) {
//            return true;
//        } else {
//            return true;
//        }
//    }

    public ArrayList<Shape> deSerialization(String filename) {
        // Deserialization

        try {
            File f = new File( filename );
            if (!f.exists()) {
                System.out.println(filename + " doesn't exist");
                return null;
            }
            // Reading the object from a file
            FileInputStream file = new FileInputStream( filename );
            InputStream buffer = new BufferedInputStream( file );
            ObjectInputStream in = new ObjectInputStream( buffer );

            // Method for deserialization of object
            shapeArrayList = (ArrayList<Shape>)in.readObject();

            System.out.println("Object has been deserialized");

            in.close();
            buffer.close();
            file.close();

            return shapeArrayList;
        } catch (IOException e) {
            System.out.println( "IOException is caught" );
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println( "ClassNotFoundException is caught" );
        }
        return null;
    }
}
