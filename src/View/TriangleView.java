package View;

import Domain.Shape;
import Domain.ShapeHolder;
import Domain.Triangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TriangleView extends TwoDView {

    public TriangleView(ShapeHolder shapeHolder) {
        super( shapeHolder );
    }

    public VBox triangleInserts(String shape, ShapeHolder shapeHolder) {
        VBox inserts = new VBox(  );
        Label side1 = new Label( "Set Side 1: " );
        TextField insertSide1 = new TextField(  );
        Label side2 = new Label( "Set Side 2: " );
        TextField insertSide2 = new TextField(  );
        Label side3 = new Label( "Set Side 3: " );
        TextField insertSide3 = new TextField(  );
        Label inserted = new Label( "" );

        //Add button with function to create new Triangle
        Button addButton = new Button( "Add "+ shape + " to shapes" );
        addButton.setOnAction( e -> {
            //Check for empty fields
            if (((insertSide1.getText().isEmpty()) || (insertSide2.getText().isEmpty()) || (insertSide3.getText().isEmpty()))) {
                inserted.setText( "Not all fields are filled in correctly" );
                //check for only numeric inputs
            } else if ((!insertSide1.getText().matches("[0-9]+") || (!insertSide2.getText().matches("[0-9]+") || (!insertSide3.getText().matches("[0-9]+"))))) {
                inserted.setText( "Not all fields are filled in correctly" );
            } else {

            double Tside1 = Double.parseDouble(insertSide1.getText());
            double Tside2 = Double.parseDouble(insertSide2.getText());
            double Tside3 = Double.parseDouble(insertSide3.getText());

            //If value == 0, no new shape will be created
            if (Tside1 > 0 && Tside2 > 0 && Tside3 > 0) {
                Triangle triangle = new Triangle( Tside1, Tside2, Tside3 );
                shapeHolder.addShape( triangle );
                inserted.setText( shape + " inserted: \n" + triangle.toString() );
            }
            }
            insertSide1.clear();
            insertSide2.clear();
            insertSide3.clear();

        } );

        HBox addButtonBox = new HBox(  );
        addButtonBox.setAlignment( Pos.BASELINE_CENTER);
        addButtonBox.getChildren().add( addButton );
        addButtonBox.setPadding( new Insets( 15 ) );

        inserts.setPadding( new Insets( 10 ) );

        inserts.getChildren().addAll( side1, insertSide1, side2, insertSide2, side3, insertSide3, addButtonBox, inserted);
        return inserts;
    }

}
