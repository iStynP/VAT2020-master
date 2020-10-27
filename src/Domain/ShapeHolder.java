package Domain;

import DataStorage.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ShapeHolder {
    private ArrayList<Shape> shapeList;
//    private List<ShapeDB> shapeDBList;
//    private DAO dao;

    public ShapeHolder() {
        this.shapeList = new ArrayList<>();
    }

    public Shape getShape(int indexNr){
        Shape shape = (Shape) shapeList.get( indexNr );
        return shape;
    }

    public void addShape(Shape shape) {
        if (!this.shapeList.contains( shape )) {
            this.shapeList.add( shape );
        }
    }

    public int amountOfShapes() {
        return this.shapeList.size();
    }

    public void deleteShape(Shape shape) {
        this.shapeList.remove( shape );
    }

    public String print() {
        int counterCircle = 0;
        int counterSquare = 0;
        int counterTriangle = 0;
        int counterSphere = 0;
        int counterBlock = 0;
        int counterCylinder = 0;
        String form;

        for (int i = 0; i < this.shapeList.size(); i++) {
            form = this.shapeList.get( i ).getNameOfShape();

            switch (form) {
                case "circle":
                    counterCircle++;
                    break;
                case "square":
                    counterSquare++;
                    break;
                case "triangle":
                    counterTriangle++;
                    break;
                case "sphere":
                    counterSphere++;
                    break;
                case "block":
                    counterBlock++;
                    break;
                case "cylinder":
                    counterCylinder++;
                    break;
            }

        }
        String circle = "";
        String square = "";
        String triangle = "";
        String sphere = "";
        String block = "";
        String cylinder = "";

        if (counterCircle > 0) {
            circle = "\ncircles: " + counterCircle;
        }
        if (counterSquare > 0) {
            square = "\nsquares: " + counterSquare;
        }
        if (counterTriangle > 0) {
            triangle = "\ntriangles: " + counterTriangle;
        }
        if (counterSphere > 0) {
            sphere = "\nspheres: " + counterSphere;
        }
        if (counterBlock > 0) {
            block = "\nblocks: " + counterBlock;
        }
        if (counterCylinder > 0) {
            cylinder = "\ncylinders: " + counterCylinder;
        }
        return "This shape-list contains: " +
                circle + square + triangle + sphere + block + cylinder + "\n\n";

    }

    public String printAllShapes() {
        String allShapes = "";
        for (int i = 0; i < shapeList.size(); i++) {
            allShapes = allShapes + shapeList.get( i ).toString();
        }
        return allShapes;
    }

    public Collection<Shape> getAll() {
        return shapeList;
    }

    public Collection<String> getAllNamesAndProperties(){
        ArrayList names = new ArrayList(  );
        for (int i = 0; i < shapeList.size(); i++) {
            String name = shapeList.get( i ).getNameOfShape();
            String properties = shapeList.get( i ).getProperties();
            String nameAndProperties = name + "\n" + properties;
            names.add( nameAndProperties );
        }
        return names;
    }

    public void addToListFromFile(String filestring) {
        String[] parts = filestring.split( "," );
        String shape = parts[0];

        //Set rest of Strings to double
        ArrayList<Double> props = new ArrayList<>(  );
        for (int i = 0; i < parts.length-1; i++) {
            props.add( Double.parseDouble( parts[i+1] ) );
        }

        switch (shape) {
            case "circle":
                Circle circle = new Circle( props.get( 0 ) );
                this.shapeList.add( circle );
                break;
            case "square":
                Square square = new Square( props.get( 0 ), props.get( 1 ));
                this.shapeList.add( square );
                break;
            case "triangle":
                Triangle triangle = new Triangle( props.get( 0 ), props.get( 1 ), props.get( 2 ) );
                this.shapeList.add( triangle );
                break;
            case "sphere":
                Sphere sphere = new Sphere( props.get( 0 ));
                this.shapeList.add( sphere );
                break;
            case "block":
                Block block = new Block( props.get( 0 ), props.get( 1 ), props.get( 2 ));
                this.shapeList.add( block );
                break;
            case "cylinder":
                Cylinder cylinder = new Cylinder( props.get( 0 ), props.get( 1 ) );
                this.shapeList.add( cylinder );
                break;
        }
    }

//    public List<Shape> getFromDB() {
//        this.shapeDBList = this.dao.getAll();
//        for (int i = 0; i < this.shapeDBList.size(); i++) {
//            String form = this.shapeDBList.get( i ).getName();
//            switch (form) {
//                case "circle":
//                Circle circle = new Circle( shapeDBList.get(i).getRadius() );
//                this.shapeList.add( circle );
//                break;
//                case "square":
//                    Square square = new Square( shapeDBList.get(i).getLength(), shapeDBList.get( i ).getWidth() );
//                    this.shapeList.add( square );
//                    break;
//                case "triangle":
//                    Triangle triangle = new Triangle( shapeDBList.get(i).getHeight(), shapeDBList.get(i).getLength(), shapeDBList.get(i).getWidth() );
//                    this.shapeList.add( triangle );
//                    break;
//                case "sphere":
//                    Sphere sphere = new Sphere( shapeDBList.get(i).getRadius() );
//                    this.shapeList.add( sphere );
//                    break;
//                case "block":
//                    Block block = new Block( shapeDBList.get(i).getLength(), shapeDBList.get(i).getWidth(), shapeDBList.get(i).getHeight() );
//                    this.shapeList.add( block );
//                    break;
//                case "cylinder":
//                    Cylinder cylinder = new Cylinder( shapeDBList.get(i).getRadius(), shapeDBList.get(i).getHeight() );
//                    this.shapeList.add( cylinder );
//                    break;
//            }
//        }
//        return this.shapeList;
//    }



}
