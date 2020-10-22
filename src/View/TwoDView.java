package View;

import Domain.ShapeHolder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TwoDView {

    private ShapeHolder shapeHolder;
    String labelText = "Choose your new 2D-Shape here";
    String shape1 = "Circle";
    String shape2 = "Square";
    String shape3 = "Triangle";

    public TwoDView(ShapeHolder shapeHolder) {
        this.shapeHolder = shapeHolder;
    }

        public Parent getView(){
        return getView( labelText, shape1, shape2, shape3 );
    }

    public Parent getView(String labelText, String shape1, String shape2, String shape3) {
        BorderPane layout = new BorderPane();
        Label label = new Label( labelText );
        layout.setPadding( new Insets( 10 ) );

        // 2D-Shapes elements
        VBox VtwoD = twoD( layout, shapeHolder );


        layout.setTop( label );
        layout.setLeft( VtwoD );


        return layout;
    }

    public VBox twoD(BorderPane bp, ShapeHolder sh) {
        VBox twoD = new VBox( );

        //Group RadioButtons
        ToggleGroup group = new ToggleGroup();

        RadioButton button = new RadioButton( shape1);
        button.setToggleGroup( group );
        RadioButton button1 = new RadioButton(shape2);
        button1.setToggleGroup( group );
        RadioButton button2 = new RadioButton( shape3 );
        button2.setToggleGroup( group );

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                // Has selection.
                if (group.getSelectedToggle() != null) {
                    RadioButton button = (RadioButton) group.getSelectedToggle();
                    if(button.getText()== shape1){
                        CircleView circleView = new CircleView( sh );
                        VBox insert = new VBox( );
                        insert = circleView.circleInserts(shape1, shapeHolder);
                        bp.setCenter( insert );
                        insert.setSpacing( 5 );
                    } else if (button.getText()== shape2){
                        SquareView squareView = new SquareView( sh );
                        VBox insert = new VBox(  );
                        insert = squareView.squareInserts(shape2, shapeHolder);
                        bp.setCenter( insert );
                        insert.setSpacing( 5 );
                    } else if (button.getText()== shape3){
                        TriangleView triangleView = new TriangleView( sh );
                        VBox insert = new VBox(  );
                        insert = triangleView.triangleInserts(shape3, shapeHolder);
                        bp.setCenter( insert );
                        insert.setSpacing( 5 );
                    };
                }
            }
        });

        twoD.getChildren().addAll( button, button1, button2 );
        twoD.setPadding( new Insets( 10, 10, 10, 10 ) );
        twoD.setSpacing( 40 );

        return twoD;
    }
}