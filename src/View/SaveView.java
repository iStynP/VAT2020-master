package View;

import BusinessLogic.FileManager;
import Domain.ShapeHolder;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SaveView extends Node {
    VBox vBox;
    HBox hbox;

    public VBox saveElement(ShapeHolder shapeHolder) {
        // Hbox in Vbox: Save to filename
        VBox vBox = new VBox();

        Label labelSave = new Label( "Save Shape-list to file here" );
        vBox.setPadding( new Insets( 5, 5, 5, 5 ) );
        vBox.setSpacing( 5 );
        vBox.setMinWidth( 275 );

        HBox saveBox = new HBox();
        Label saveLabel = new Label( "Enter filename:" );
        saveBox.setSpacing( 10 );
        saveBox.setPadding( new Insets( 5, 5, 5, 5 ) );
        TextField saveField = new TextField();
        Label savedSuccessfully = new Label( "" );

//Savebutton function, save file as entered filename via Filemanager
        Button saveButton = new Button( "Save" );
        saveButton.setOnAction( actionEvent -> {
            FileManager fileManager = new FileManager( shapeHolder );
            try {
                String fileName = saveField.getText();
                if (!fileName.isEmpty()) {
                    fileManager.writeToFile( fileName );
                    savedSuccessfully.setText( "Saved successfully!" );
                    saveField.clear();

                } else {
                    saveField.clear();
                    savedSuccessfully.setText( "(Set filename)" );
                }
            } catch (Exception e) {
                saveField.clear();
                savedSuccessfully.setText( e.getMessage() );
            }
        } );

        saveBox.getChildren().addAll(  saveField, saveButton );
        vBox.getChildren().addAll( labelSave, saveLabel, saveBox, savedSuccessfully );
        return vBox;
    }
}
