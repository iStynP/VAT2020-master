package View;

import Domain.ShapeHolder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

        // 3D-Shapes elements
        VBox VthreeD = twoD( layout, shapeHolder );

        //Make separator
        Separator separator = new Separator();
        separator.setMinWidth( 300 );
        separator.setHalignment( HPos.CENTER );

        //Make SaveView
        SaveView saveView = new SaveView();
        //Make LoadView
        LoadView loadview = new LoadView();
        //Put them in Hbox
        HBox saveAndLoad = new HBox(  );
        //Add Loadview to Hbox
        saveAndLoad.getChildren().addAll( saveView.saveElement(shapeHolder), loadview.loadFile( shapeHolder ) );

        VBox sepSaveAndLoad = new VBox(  );
        sepSaveAndLoad.setPadding( new Insets( 10 ) );
        sepSaveAndLoad.getChildren().addAll( separator, saveAndLoad );

        //Get ListViewElement
        ListShapeView listShapeView = new ListShapeView( shapeHolder );
        VBox listShapes = listShapeView.getView();

        layout.setTop( label );
        layout.setLeft( VthreeD );
        layout.setBottom( sepSaveAndLoad );
        layout.setRight( listShapes );




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

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                // Has selection.
                if (group.getSelectedToggle() != null) {
                    RadioButton button = (RadioButton) group.getSelectedToggle();
                    if(button.getText()== shape1){
                        BlocView blockView = new BlocView( sh );
                        VBox insert = new VBox(  );
                        insert = blockView.blockInserts(shape1, shapeHolder);
                        bp.setCenter( insert );
                        insert.setSpacing( 5 );
                    } else if (button.getText()== shape2){
                        CylinderView cylinderView = new CylinderView( sh );
                        VBox insert = new VBox(  );
                        insert = cylinderView.cylinderInsert(shape2, shapeHolder);
                        bp.setCenter( insert );
                        insert.setSpacing( 5 );
                    } else if (button.getText()== shape3){
                        SphereView sphereView = new SphereView( sh );
                        VBox insert = new VBox(  );
                        insert = sphereView.sphereInserts(shape3, shapeHolder);
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
