package View;

import Domain.ShapeHolder;
import Domain.Square;
import Domain.Triangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SquareView extends TwoDView {
    public SquareView(ShapeHolder shapeHolder) {
        super( shapeHolder );
    }

    public VBox squareInserts(String shape, ShapeHolder shapeHolder) {
        VBox inserts = new VBox(  );
        Label length = new Label( "Set Length: " );
        TextField insertLength = new TextField(  );
        Label width = new Label( "Set Width: " );
        TextField insertWidth = new TextField(  );
        inserts.setPadding( new Insets( 10 ) );
        Label inserted = new Label( "" );

        //Add button with function to create new Square
        Button addButton = new Button( "Add "+ shape + " to shapes" );
        addButton.setOnAction( e -> {
            double Slength = Double.parseDouble(insertLength.getText());
            double Swidth = Double.parseDouble(insertWidth.getText());

            //If a value == 0, no new shape will be created
            if (Slength > 0 && Swidth > 0) {
                Square square = new Square( Slength, Swidth );
                shapeHolder.addShape( square );
                inserted.setText( shape + " inserted: \n"+square.toString() );
            }
            insertLength.clear();
            insertWidth.clear();

        } );

        HBox addButtonBox = new HBox(  );
        addButtonBox.setAlignment( Pos.BASELINE_CENTER);
        addButtonBox.getChildren().add( addButton );
        addButtonBox.setPadding( new Insets( 15 ) );

        inserts.getChildren().addAll( length, insertLength, width, insertWidth, addButtonBox, inserted);
        return inserts;
    }
}
