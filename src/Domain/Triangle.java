package Domain;

import java.text.DecimalFormat;

/**
 * @author Rodney
 */
public class Triangle extends TwoDimensionalShape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
       super("triangle");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Calculate surface from triangle
     * Heron's Formula is used (calculates triangle's area from the lengths of it's sides)
     * Step 1. Calculate "s" (half of the triangles perimeter)
     * Step 2. Calculate the Area
     * @return
     */
    @Override
    public double getSurface() {
        double s = (this.sideA + this.sideB + this.sideC) / 2;

        double area = Math.sqrt( s * (s - sideA) * (s - sideB) * (s - sideC) );
        return area;
    }

    /**
     * Calculate perimeter from triangle
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getNameOfShape() {
        return super.getNameOfShape();
    }

    @Override
    public String toString() {
        String strSideA = ( new DecimalFormat("##.##").format(this.sideA) );
        String strSideB = ( new DecimalFormat("##.##").format(this.sideB) );
        String strSideC = ( new DecimalFormat("##.##").format(this.sideC) );
        return
//                "Side A= " + strSideA + " cm\n" +
//                "Side B= " + strSideB + " cm\n" +
//                "Side C= " + strSideC + " cm\n" +
                super.toString();
    }

    @Override
    public double getLength() {
        return this.sideA;
    }

    @Override
    public double getWidth() {
        return this.sideB;
    }

    @Override
    public double getHeight() {
        return this.sideC;
    }
}
