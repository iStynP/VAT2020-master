package Domain;

import java.text.DecimalFormat;

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
        String strLength = ( new DecimalFormat("##.##").format(this.length) );
        String strWidth = ( new DecimalFormat("##.##").format(this.width) );
        return
//                "Length = " + strLength + " cm\n" +
//                "Width = " + strWidth + " cm\n" +
                super.toString();
    }

    @Override
    public double getLength() {
        return this.length;
    }

    @Override
    public double getWidth() {
        return this.width;
    }
}
