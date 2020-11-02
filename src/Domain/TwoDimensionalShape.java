package Domain;

import BusinessLogic.FileManager;

import java.text.DecimalFormat;

public class TwoDimensionalShape implements Shape {
    private double surface;
    private double perimeter;
    private String name;
    private ShapeHolder shapeHolder;
    private FileManager fileManager;
//    private String uniqueId;


    public TwoDimensionalShape(String name) {
        this.name = name;
//        this.uniqueId = generateUniqueId();
    }

    public double getSurface(){
        return surface;
    }

    public double getPerimeter(){
        return perimeter;
    }

    public String getNameOfShape() {
        return this.name;
    }

    @Override
    public String getProperties() {
        String strSurface = ( new DecimalFormat("##.##").format(getSurface()) );
        String strPerimeter = ( new DecimalFormat("##.##").format(getPerimeter()) );
        return "(" + strSurface + " cm\u00B2" + "/" + strPerimeter + "cm)";
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
        String strSurface = ( new DecimalFormat("##.##").format(getSurface()) );
        String strPerimeter = ( new DecimalFormat("##.##").format(getPerimeter()) );
        return "This " + name + " has a surface of " + strSurface + " cm\u00B2\n" +
                "and a perimeter of " + strPerimeter + " cm\n\n";
    }

}
