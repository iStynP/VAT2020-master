package Domain;

/**
 * @author Rodney
 */
public class Square extends TwoDimensionalShape {
    private double length;
    private double width;

    public Square(double length, double width) {
        super("square");
        this.length = length;
        this.width = width;
    }

    /**
     * Calculate surface from square
     * @return surface
     */
    @Override
    public double getSurface() {
        return this.length * this.width;
    }

    /**
     * Calculate perimeter from square
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        return (this.length + this.width)*2;
    }

    @Override
    public String getNameOfShape() {
        return super.getNameOfShape();
    }

    @Override
    public String toString() {
        return  "Length = " + this.length + " cm\n" +
                "Width = " + this.width + " cm\n" +
                super.toString();
    }
}
