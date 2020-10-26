package Domain;

import java.util.ArrayList;

public class ShapeHolder {
    private ArrayList<Shape> shapeList;

    public ShapeHolder() {
        this.shapeList = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        if (!this.shapeList.contains(shape)) {
            this.shapeList.add(shape);
        }
    }

    public int amountOfShapes() {
        return this.shapeList.size();
    }

    public void deleteShape(Shape shape) {
        this.shapeList.remove(shape);
    }

    public String print() {
        int counterCircle = 0;
        int counterSquare = 0;
        int counterTriangle = 0;
        int counterSphere = 0;
        int counterBlock = 0;
        int counterCylinder = 0;
        String form;

        for (int i = 0; i < this.shapeList.size(); i++) {
            form = this.shapeList.get(i).getNameOfShape();

            switch (form) {
                case "circle":
                    counterCircle++;
                    break;
                case "square":
                    counterSquare++;
                    break;
                case "triangle":
                    counterTriangle++;
                    break;
                case "sphere":
                    counterSphere++;
                    break;
                case "block":
                    counterBlock++;
                    break;
                case "cylinder":
                    counterCylinder++;
                    break;
            }

        }
        String circle = "";
        String square = "";
        String triangle = "";
        String sphere = "";
        String block = "";
        String cylinder = "";

        if (counterCircle > 0) {
            circle = "\ncircles: " + counterCircle;
        }
        if (counterSquare > 0) {
            square = "\nsquares: " + counterSquare;
        }
        if (counterTriangle > 0) {
            triangle = "\ntriangles: " + counterTriangle;
        }
        if (counterSphere > 0) {
            sphere = "\nspheres: " + counterSphere;
        }
        if (counterBlock > 0) {
            block = "\nblocks: " + counterBlock;
        }
        if (counterCylinder > 0) {
            cylinder = "\ncylinders: " + counterCylinder;
        }
        return "This shape-list contains: " +
                circle + square + triangle + sphere + block + cylinder + "\n\n";

    }

    public String printAllShapes() {
        String allShapes = "";
        for (int i = 0; i < shapeList.size(); i++) {
            allShapes = allShapes + shapeList.get(i).toString();
        }
        return allShapes;
    }


}

