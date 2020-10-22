package Domain;

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
        return  "Side A= " + sideA + " cm\n" +
                "Side B= " + sideB + " cm\n" +
                "Side C= " + sideC + " cm\n" +
                super.toString();
    }
}
