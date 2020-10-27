package Domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodney
 */
public class ShapeDB {

    private int id;
    private String name;
    private double radius, length, width, height;

    private  List<ShapeDB> shapesFromDB;

    public ShapeDB(List<ShapeDB> shapesFromDB){
        this.shapesFromDB = shapesFromDB;
    }

    public ShapeDB(int id, String name, double radius, double length, double width, double height) {

        this.id = id;
        this.name = name;
        this.radius = radius;
        this.length = length;
        this.width = width;
        this.height = height;

        shapesFromDB = new ArrayList<>();

    }


    // Getters
    public List<ShapeDB> getAll(){
        return shapesFromDB;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRadius() {
        return radius;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Setters
    public void setId() {
        this.id = id;
    }

    public void setName() {
        this.name = name;
    }

    public void setRadius() {
        this.radius = radius;
    }

    public void setLength() {
        this.length = length;
    }

    public void setWidth() {
        this.width = width;
    }

    public void setHeight() {
        this.height = height;

    }

    public void save(ShapeDB shapeDB) {

    }
}
