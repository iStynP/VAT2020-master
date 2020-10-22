package Domain;

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
        return "This " + name + " has a total surface of " + getTotalSurface() + " cm2\n" +
                "and a volume of " + getVolume() + " cm3";
    }
}
