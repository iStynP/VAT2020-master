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
        //Horizontal separator
        Separator separator = new Separator();
        separator.setMinWidth( 300 );
        separator.setHalignment( HPos.CENTER );
        Label labelSave = new Label( "Save Shape-list here" );
        vBox.setPadding( new Insets( 0, 15, 10, 15 ) );
        vBox.setSpacing( 5 );

        HBox saveBox = new HBox();
        Label saveLabel = new Label( "Enter filename:" );
        saveBox.setSpacing( 10 );
        saveBox.setPadding( new Insets( 10, 15, 10, 15 ) );
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

        saveBox.getChildren().addAll( saveLabel, saveField, saveButton );
        vBox.getChildren().addAll( separator, labelSave, saveBox, savedSuccessfully );
        return vBox;
    }
}
