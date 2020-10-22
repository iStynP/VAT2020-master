package view;

import Domain.ShapeHolder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javax.swing.text.html.BlockView;

public class ThreeDView {

    private ShapeHolder shapeHolder;
    String labelText = "Choose your new 3D-Shape here";
    String shape1 = "Block";
    String shape2 = "Cylinder";
    String shape3 = "Sphere";

    public ThreeDView(ShapeHolder shapeHolder) {
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
        VBox twoD = new VBox(  );

        //Group RadioButtons
        ToggleGroup group = new ToggleGroup();

        RadioButton button = new RadioButton( shape1);
        button.setToggleGroup( group );
        RadioButton button1 = new RadioButton(shape2);
        button1.setToggleGroup( group );
        RadioButton button2 = new RadioButton( shape3 );
        button2.setToggleGroup( group );

//        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//            @Override
//            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
//                // Has selection.
//                if (group.getSelectedToggle() != null) {
//                    RadioButton button = (RadioButton) group.getSelectedToggle();
//                    if(button.getText()== shape1){
//                        BlocView blockView = new BlocView( sh );
//                        VBox insert = new VBox(  );
//                        insert = blockView.blockInserts();
//                        bp.setCenter( insert );
//                        insert.setSpacing( 5 );
//                    } else if (button.getText()== shape2){
//                        CylinderView cylinderView = new CylinderView( sh );
//                        VBox insert = new VBox(  );
//                        insert = cylinderView.cylinderInsert();
//                        bp.setCenter( insert );
//                        insert.setSpacing( 5 );
//                    } else if (button.getText()== shape3){
//                        SphereView sphereView = new SphereView( sh );
//                        VBox insert = new VBox(  );
//                        insert = sphereView.sphereInserts();
//                        bp.setCenter( insert );
//                        insert.setSpacing( 5 );
//                    };
//                }
//            }
//        });

        twoD.getChildren().addAll( button, button1, button2 );
        twoD.setPadding( new Insets( 10, 10, 10, 10 ) );
        twoD.setSpacing( 40 );

        return twoD;
    }
}
