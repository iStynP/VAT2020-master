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
        Label saveToFile = new Label( "" );
        HBox toTextorNo = new HBox(  );
        toTextorNo.setPadding( new Insets( 5, 5, 5, 5 ) );
        toTextorNo.setSpacing( 5 );
        Button saveToText = new Button( "Save to .txt" );
        Button noThanks = new Button( "No thanks" );
        toTextorNo.getChildren().addAll( saveToText, noThanks );
        toTextorNo.setVisible( false );

//Savebutton function, save file as entered filename via Filemanager
        Button saveButton = new Button( "Save to file" );
        saveButton.setOnAction( actionEvent -> {
            FileManager fileManager = new FileManager( shapeHolder );
            if (shapeHolder.amountOfShapes() < 1) {
savedSuccessfully.setText( "(Shapelist is Empty)" );
            } else {

                try {
                    String fileName = saveField.getText();
                    if (!fileName.isEmpty()) {
                        fileManager.serialization( fileName );
                        saveButton.setVisible( false );
                        savedSuccessfully.setText( "Saved successfully to file!" );
                        saveToFile.setText( "Would you also like to save the Shapelist to a textfile?" );
                        saveToFile.setVisible( true );
                        toTextorNo.setVisible( true );

                        // Does the user want to print the Shape-list to a text-file?
                        // Also save to text button-function
                        saveToText.setOnAction( actionEvent1 -> {
                            fileManager.writeToFile( fileName );
                            saveToFile.setVisible( false );
                            saveButton.setVisible( true );
                            saveToText.setVisible( false );
                            toTextorNo.setVisible( false );
                            saveField.clear();
                        } );
                        // NoThanks button-function
                        noThanks.setOnAction( actionEvent2 -> {
                            saveToFile.setVisible( false );
                            saveButton.setVisible( true );
                            saveToText.setVisible( false );
                            toTextorNo.setVisible( false );
                            saveField.clear();
                        } );


                        saveToText.setVisible( true );

                    } else {
                        saveField.clear();
                        savedSuccessfully.setText( "(Set filename)" );
                    }
                } catch (Exception e) {
                    saveField.clear();
                    savedSuccessfully.setText( e.getMessage() );
                }
            }
        } );

        saveBox.getChildren().addAll(  saveField, saveButton );
        vBox.getChildren().addAll( labelSave, saveLabel, saveBox, savedSuccessfully, saveToFile, toTextorNo );
        return vBox;
    }
}
