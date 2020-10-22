package Domain;

/**
 * @author Rodney
 */
public class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        super( "cylinder" );
        this.radius = radius;
        this.height = height;
    }

    /**
     * Calculate surface from circle * height
     * @return
     */
    @Override
    public double getVolume() {
        return (Math.PI * (this.radius * this.radius))*this.height;
    }

    /**
     * Step 1. Calculate top + bottom surface
     * Step 2. Calculate lateral surface area
     * @return
     */
    @Override
    public double getTotalSurface() {
        double topBottom = (Math.PI * (this.radius * this.radius)) * 2;
        double lsa = 2 * Math.PI * this.radius * this.height;
        return topBottom + lsa;
    }

    @Override
    public String getNameOfShape() {
        return super.getNameOfShape();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
