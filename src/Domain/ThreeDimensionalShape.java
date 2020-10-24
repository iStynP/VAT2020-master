package Domain;

import java.text.DecimalFormat;

public class ThreeDimensionalShape implements Shape{
    private double volume;
    private double totalSurface;
    private String name;

    public ThreeDimensionalShape(String name) {
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public double getTotalSurface() {
        return totalSurface;
    }

    public String getNameOfShape() {
        return this.name;
    }

    public String toString() {
        String strTotalSurface = ( new DecimalFormat("##.##").format(getTotalSurface()) );
        String strTotalVolume = ( new DecimalFormat("##.##").format(getVolume()) );
        return "This " + name + " has a total surface of " + strTotalSurface + " cm2\n" +
                "and a volume of " + strTotalVolume + " cm3";
    }
}
