package view;

import Domain.ShapeHolder;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SquareView extends TwoDView {
    public SquareView(ShapeHolder shapeHolder) {
        super( shapeHolder );
    }

    public VBox squareInserts() {
        VBox inserts = new VBox(  );
        Label length = new Label( "Set Length: " );
        TextField insertLength = new TextField(  );
        Label width = new Label( "Set Width: " );
        TextField insertWidth = new TextField(  );
        inserts.setPadding( new Insets( 10 ) );

        inserts.getChildren().addAll( length, insertLength, width, insertWidth);
        return inserts;
    }
}
