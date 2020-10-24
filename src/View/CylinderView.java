package View;

import Domain.Circle;
import Domain.Cylinder;
import Domain.ShapeHolder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CylinderView extends ThreeDView{
    public CylinderView(ShapeHolder shapeHolder) {
        super( shapeHolder );
    }

    public VBox cylinderInsert(String shape, ShapeHolder shapeHolder) {
        VBox inserts = new VBox(  );
        Label radius = new Label( "Set Radius: " );
        TextField insertRadius = new TextField(  );
        Label height = new Label( "Set height: " );
        TextField insertHeight = new TextField(  );
        inserts.setPadding( new Insets( 10 ) );
        Label inserted = new Label( "" );

        //Add button with function to create new Cylinder
        Button addButton = new Button( "Add "+ shape + " to shapes" );
        addButton.setOnAction( e -> {
            double CRadius = Double.parseDouble(insertRadius.getText());
            double Cheight = Double.parseDouble(insertHeight.getText());

            //If a value == 0, no new shape will be created
            if (CRadius > 0 && Cheight > 0) {
                Cylinder cylinder = new Cylinder( CRadius, Cheight );
                shapeHolder.addShape( cylinder );
                inserted.setText( shape + " inserted: \n"+cylinder.toString() );

            }
            insertRadius.clear();
        } );

        HBox addButtonBox = new HBox(  );
        addButtonBox.setAlignment( Pos.BASELINE_CENTER);
        addButtonBox.getChildren().add( addButton );
        addButtonBox.setPadding( new Insets( 15 ) );

        inserts.getChildren().addAll( radius, insertRadius, height, insertHeight, addButtonBox, inserted );
        return inserts;
    }
}
