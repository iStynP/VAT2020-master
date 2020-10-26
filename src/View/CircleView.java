package View;

import Domain.Circle;
import Domain.ShapeHolder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CircleView extends TwoDView {

    public CircleView(ShapeHolder shapeHolder) {
        super( shapeHolder );
    }

    public VBox circleInserts(String shape, ShapeHolder shapeHolder) {
        VBox inserts = new VBox(  );
        Label radius = new Label( "Set Radius: " );
        TextField insertRadius = new TextField(  );
        inserts.setPadding( new Insets( 10 ) );
        Label inserted = new Label( "" );

        //Add button with function to create new Circle
        Button addButton = new Button( "Add "+ shape + " to shapes" );
        addButton.setOnAction( e -> {
            //Check for empty fields
            if (((insertRadius.getText().isEmpty()))) {
                inserted.setText( "Not all fields are filled in correctly" );
                //check for only numeric inputs
            } else if ((!insertRadius.getText().matches("[0-9]+"))) {
                inserted.setText( "Not all fields are filled in correctly" );
            } else {
                double CRadius = Double.parseDouble( insertRadius.getText() );

                //If value == 0, no new shape will be created
                if (CRadius > 0) {
                    Circle circle = new Circle( CRadius );
                    shapeHolder.addShape( circle );
                    inserted.setText( shape + " inserted: \n" + circle.toString() );

                }
            }
            insertRadius.clear();
        } );

        HBox addButtonBox = new HBox(  );
        addButtonBox.setAlignment( Pos.BASELINE_CENTER);
        addButtonBox.getChildren().add( addButton );
        addButtonBox.setPadding( new Insets( 15 ) );


        inserts.getChildren().addAll( radius, insertRadius, addButtonBox, inserted );
        return inserts;
    }
}
