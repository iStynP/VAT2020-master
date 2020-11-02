package Domain;

import BusinessLogic.FileManager;

import java.text.DecimalFormat;

public class ThreeDimensionalShape implements Shape{
    private double volume;
    private double totalSurface;
    private String name;
    private ShapeHolder shapeHolder;
    private FileManager fileManager;
//    private String uniqueId;

    public ThreeDimensionalShape(String name) {
        this.name = name;
//        this.uniqueId = generateUniqueId();
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

    @Override
    public double getRadius() {
        return 0;
    }

    @Override
    public double getLength() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public void serialization(String filename) {
        // Serialization
        fileManager.serialization( filename );
    }

    @Override
    public void deSerialization(String filename) {
        // Deserialization
        fileManager.deSerialization( filename );

    }

//    public String getUniqueId() {
//        return this.uniqueId;
//    }
//
//    public String generateUniqueId() {
//        UniqueID unique = new UniqueID();
//        return unique.getUniqueId();
//    }


    public String toString() {
        String strTotalSurface = ( new DecimalFormat("##.##").format(getTotalSurface()) );
        String strTotalVolume = ( new DecimalFormat("##.##").format(getVolume()) );
        return "This " + name + " has a total surface of " + strTotalSurface + " cm\u00B2\n" +
                "and a volume of " + strTotalVolume + " cm\u00B3\n\n";
    }
}
