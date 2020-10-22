package Domain;

/**
 * @author Rodney
 */
public class Block extends ThreeDimensionalShape {
    private double length;
    private double width;
    private double height;

    public Block(double length, double width, double height) {
        super("block");
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Calculate volume = length * width * height
     * @return volume
     */
    @Override
    public double getVolume() {
        return (this.length*this.height*this.width);
    }

    /**
     * Calculate Total surface
     * Step 1. calculate top are
     * Step 2. calculate side area
     * Step 3. calculate front area
     * Step 4. total surface =(top + side + front) * 2
     * @return totalSurface
     */
    @Override
    public double getTotalSurface() {
        double top = this.length*this.width;
        double front = this.width * this.height;
        double side = this.length * this.height;
        return (top + side + front) * 2;
    }

    @Override
    public String getNameOfShape() {
        return super.getNameOfShape();
    }

    @Override
    public String toString() {
        return "Length = " + this.length + " cm\n" +
                "Width = " + this.width + " cm\n" +
                "Height = " + this.height + " cm\n" +
                super.toString();
    }
}
