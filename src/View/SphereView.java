package View;

import Domain.Circle;
import Domain.ShapeHolder;
import Domain.Sphere;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SphereView extends ThreeDView {
    public SphereView(ShapeHolder shapeHolder) {
        super( shapeHolder );
    }

    public VBox sphereInserts(String shape, ShapeHolder shapeHolder) {
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
                double SRadius = Double.parseDouble( insertRadius.getText() );

                //If value == 0, no new shape will be created
                if (SRadius > 0) {
                    Sphere sphere = new Sphere( SRadius );
                    shapeHolder.addShape( sphere );
                    inserted.setText( shape + " inserted: \n" + sphere.toString() );

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
