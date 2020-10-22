package Domain;

import java.util.Objects;

public class TwoDimensionalShape implements Shape {
    private double surface;
    private double perimeter;
    private String name;

    public TwoDimensionalShape(String name) {
        this.name = name;
    }

    public double getSurface(){
        return surface;
    }

    public double getPerimeter(){
        return perimeter;
    }

    public String getNameOfShape() {
        return this.name;
    }

    public String toString() {
        return "This " + name + " has a surface of " + getSurface() + " cm2\n" +
                "and a perimeter of " + getPerimeter() + " cm";
    }

}
