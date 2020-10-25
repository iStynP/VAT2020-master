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

    @Override
    public String getProperties() {
        String strTotalSurface = ( new DecimalFormat("##.##").format(getTotalSurface()) );
        String strTotalVolume = ( new DecimalFormat("##.##").format(getVolume()) );
        return "(" + strTotalSurface + " cm\u00B2" + "/" + strTotalVolume + "cm\u00B3)";
    }

    public String toString() {
        String strTotalSurface = ( new DecimalFormat("##.##").format(getTotalSurface()) );
        String strTotalVolume = ( new DecimalFormat("##.##").format(getVolume()) );
        return "This " + name + " has a total surface of " + strTotalSurface + " cm\u00B2\n" +
                "and a volume of " + strTotalVolume + " cm\u00B3\n\n";
    }
}
