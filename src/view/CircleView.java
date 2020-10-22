package view;

import Domain.ShapeHolder;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CircleView extends TwoDView {

    public CircleView(ShapeHolder shapeHolder) {
        super( shapeHolder );
    }

    public VBox circleInserts() {
        VBox inserts = new VBox(  );
        Label radius = new Label( "Set Radius: " );
        TextField insertRadius = new TextField(  );
        inserts.setPadding( new Insets( 10 ) );

        inserts.getChildren().addAll( radius, insertRadius );
        return inserts;
    }
}
