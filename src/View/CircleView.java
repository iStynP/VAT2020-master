package View;

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

    public VBox circleInserts(String shape) {
        VBox inserts = new VBox(  );
        Label radius = new Label( "Set Radius: " );
        TextField insertRadius = new TextField(  );
        inserts.setPadding( new Insets( 10 ) );

        Button addButton = new Button( "Add "+ shape + " to shapes" );
        HBox addButtonBox = new HBox(  );
        addButtonBox.setAlignment( Pos.BASELINE_CENTER);
        addButtonBox.getChildren().add( addButton );
        addButtonBox.setPadding( new Insets( 15 ) );


        inserts.getChildren().addAll( radius, insertRadius, addButtonBox );
        return inserts;
    }
}
