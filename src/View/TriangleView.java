package View;

import Domain.ShapeHolder;
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

    public VBox triangleInserts(String shape) {
        VBox inserts = new VBox(  );
        Label side1 = new Label( "Set Side 1: " );
        TextField insertSide1 = new TextField(  );
        Label side2 = new Label( "Set Side 2: " );
        TextField insertSide2 = new TextField(  );
        Label side3 = new Label( "Set Side 3: " );
        TextField insertSide3 = new TextField(  );

        Button addButton = new Button( "Add "+ shape + " to shapes" );
        HBox addButtonBox = new HBox(  );
        addButtonBox.setAlignment( Pos.BASELINE_CENTER);
        addButtonBox.getChildren().add( addButton );
        addButtonBox.setPadding( new Insets( 15 ) );

        inserts.setPadding( new Insets( 10 ) );

        inserts.getChildren().addAll( side1, insertSide1, side2, insertSide2, side3, insertSide3, addButtonBox);
        return inserts;
    }
}
