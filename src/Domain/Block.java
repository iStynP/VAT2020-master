package Domain;

import java.text.DecimalFormat;
import java.io.Serializable;

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
        return   Double.parseDouble(new DecimalFormat("##.##").format((this.length*this.height*this.width)));

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
        String strLengt = ( new DecimalFormat("##.##").format(this.length) );
        String strWidth = ( new DecimalFormat("##.##").format(this.width) );
        String strHeight = ( new DecimalFormat("##.##").format(this.height) );
        return
//                "Length = " + strLengt + " cm\n" +
//                "Width = " + strWidth + " cm\n" +
//                "Height = " + strHeight + " cm\n" +
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

    @Override
    public double getHeight() {
        return this.height;
    }
}
