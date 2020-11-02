package Domain;

/**
 * @author Rodney
 */
public class Sphere extends ThreeDimensionalShape{
    private double radius;

    public Sphere(double radius) {
        super("sphere");
        this.radius = radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    /**
     * Calculate volume sphere
     * V = (4/3)*π*r^3
     * @return volume
     */
    @Override
    public double getVolume() {
        return (4.00/3.00)*Math.PI*Math.pow( this.radius,3 );
    }

    /**
     * Calculate total surface of sphere
     * 4*π*r^2
     * @return totalSurface
     */
    @Override
    public double getTotalSurface() {
        return 4.00*Math.PI*(this.radius*this.radius);
    }

    @Override
    public String getNameOfShape() {
        return super.getNameOfShape();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double getRadius() {
        return this.radius;
    }
}
