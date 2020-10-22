package Domain;

import java.awt.*;

public class Circle extends TwoDimensionalShape {
    private double radius;

    public Circle(double radius) {
        super( "circle" );
        this.radius = radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    /**
     * Calculate surface from circle
     * @return surface
     */
    @Override
    public double getSurface() {
        return Math.PI * (radius * radius);
    }

    /**
     * Calculate perimeter from circle
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String getNameOfShape() {
        return super.getNameOfShape();
    }

    @Override
    public String toString() {
        return "Radius = " + this.radius + "cm (Diameter = " + this.getDiameter() + " cm)\n" +
                super.toString();
    }

}
