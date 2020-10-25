package Domain;

import java.text.DecimalFormat;
import java.util.Objects;

public class TwoDimensionalShape implements Shape {
    private double surface;
    private double perimeter;
    private String name;

    public TwoDimensionalShape(String name) {
        this.name = name;
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

    public String toString() {
        String strSurface = ( new DecimalFormat("##.##").format(getSurface()) );
        String strPerimeter = ( new DecimalFormat("##.##").format(getPerimeter()) );
        return "This " + name + " has a surface of " + strSurface + " cm\u00B2\n" +
                "and a perimeter of " + strPerimeter + " cm\n\n";
    }

}
