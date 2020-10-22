package View;

import Domain.ShapeHolder;
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

    public VBox blockInserts(String shape) {
        VBox inserts = new VBox(  );
        Label length = new Label( "Set Length: " );
        TextField insertLength = new TextField(  );
        Label width = new Label( "Set Width: " );
        TextField insertWidth = new TextField(  );
        Label height = new Label( "Set Height: " );
        TextField insertHeight = new TextField(  );
        inserts.setPadding( new Insets( 10 ) );

        Button addButton = new Button( "Add "+ shape + " to shapes" );
        HBox addButtonBox = new HBox(  );
        addButtonBox.setAlignment( Pos.BASELINE_CENTER);
        addButtonBox.getChildren().add( addButton );
        addButtonBox.setPadding( new Insets( 15 ) );

        inserts.getChildren().addAll( length, insertLength, width, insertWidth, height, insertHeight, addButtonBox);
        return inserts;
    }
}
