package View;

import Domain.Block;
import Domain.ShapeHolder;
import Domain.Square;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BlocView extends ThreeDView {
    public BlocView(ShapeHolder shapeHolder) {
        super( shapeHolder );
    }

    public VBox blockInserts(String shape, ShapeHolder shapeHolder) {
        VBox inserts = new VBox();
        Label length = new Label( "Set Length: " );
        TextField insertLength = new TextField();
        Label width = new Label( "Set Width: " );
        TextField insertWidth = new TextField();
        Label height = new Label( "Set Height: " );
        TextField insertHeight = new TextField();
        inserts.setPadding( new Insets( 10 ) );
        Label inserted = new Label( "" );

        //Add button with function to create new Block
        Button addButton = new Button( "Add " + shape + " to shapes" );
        addButton.setOnAction( e -> {
            double Blength = Double.parseDouble( insertLength.getText() );
            double Bwidth = Double.parseDouble( insertWidth.getText() );
            double Bheight = Double.parseDouble( insertHeight.getText() );

            //If a value == 0, no new shape will be created
            if (Blength > 0 && Bwidth > 0 && Bheight > 0) {
                Block block = new Block( Blength, Bwidth, Bheight );
                shapeHolder.addShape( block );
                inserted.setText( shape + " inserted: \n" + block.toString() );

            }
            insertLength.clear();
            insertWidth.clear();
            insertHeight.clear();

        } );

        HBox addButtonBox = new HBox();
        addButtonBox.setAlignment( Pos.BASELINE_CENTER );
        addButtonBox.getChildren().add( addButton );
        addButtonBox.setPadding( new Insets( 15 ) );

        inserts.getChildren().addAll( length, insertLength, width, insertWidth, height, insertHeight, addButtonBox, inserted );
        return inserts;
    }
}
