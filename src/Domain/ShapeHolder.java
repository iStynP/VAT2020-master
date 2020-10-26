package Domain;

import DataStorage.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShapeHolder {

    private ArrayList<Shape> shapeList;
    private ArrayList<ShapeDB> shapeListFromDB;
    private List<ShapeDB> shapeDBList;
    private DAO dao;

    public ShapeHolder() {
        this.shapeList = new ArrayList<>();
        this.shapeListFromDB = new ArrayList<>();
    }

    public Shape getShape(int indexNr) {
        Shape shape = (Shape) shapeList.get(indexNr);
        return shape;
    }

    public ShapeDB getShapeFromDB(int Id) {
        ShapeDB shapeDB = shapeListFromDB.get(Id);
        return shapeDB;
    }

    public void addShape(Shape shape) {
        if (!this.shapeList.contains(shape)) {
            this.shapeList.add(shape);
        }
    }

    public void addShapeToDB(ShapeDB shapeDB) {
        if (!this.shapeListFromDB.contains(shapeDB)) {
            this.shapeListFromDB.add(shapeDB);
        }
    }

    public int amountOfShapes() {
        return this.shapeList.size();
    }

    public int amountOfShapesFromDB() {
        return this.shapeListFromDB.size();
    }

    public void deleteShape(Shape shape) {
        this.shapeList.remove(shape);
    }

    public void deleteShapeFromDB(ShapeDB shapeDB) {
        this.shapeListFromDB.remove(shapeDB);
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
            form = this.shapeList.get(i).getNameOfShape();

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
            allShapes = allShapes + shapeList.get(i).toString();
        }
        return allShapes;
    }

    public Collection<Shape> getAll() {
        return shapeList;
    }

    public Collection<ShapeDB> getAllFromDB() {
        return shapeListFromDB;
    }

    public Collection<String> getAllNamesAndProperties() {
        ArrayList names = new ArrayList();
        for (int i = 0; i < shapeList.size(); i++) {
            String name = shapeList.get(i).getNameOfShape();
            String properties = shapeList.get(i).getProperties();
            String nameAndProperties = name + "\n" + properties;
            names.add(nameAndProperties);
        }
        return names;
    }

    public Collection<String> getAllNamesFromDB() {
        ArrayList namesFromDB = new ArrayList();
        for (int i = 0; i < shapeListFromDB.size(); i++) {
            String name = shapeListFromDB.get(i).getNameOfShape();
            String properties = shapeListFromDB.get(i).getName();
            String nameFromDB = name + "\n" + properties;
            namesFromDB.add(namesFromDB);
        }
        return namesFromDB;
    }


    public void setShapeList(ArrayList<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public void setShapeListFromDB(ArrayList<ShapeDB> shapeListFromDB) {
        this.shapeListFromDB = shapeListFromDB;
    }

    public List<ShapeDB> getFromDB() {

        this.shapeDBList = this.dao.getAllFromDB();
        for (int i = 0; i < this.shapeDBList.size(); i++) {
            this.shapeDBList.get(i).getName();
        }

        return shapeListFromDB;
    }
}







