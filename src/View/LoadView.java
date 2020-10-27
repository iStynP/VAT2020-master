package View;

import BusinessLogic.FileManager;
import Domain.ShapeHolder;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoadView extends Node {
    VBox vBox;
    HBox hBox;

    public VBox loadFile(ShapeHolder shapeHolder) {
        // Hbox in Vbox: Load to shapeHolder (list)
        VBox vBox = new VBox();

        Label labelLoad = new Label( "Load shapes from text here" );
        Label loadLabel = new Label( "Enter filename to load:" );
        vBox.setPadding( new Insets( 5, 5, 5, 5 ) );
        vBox.setSpacing( 5 );
        vBox.setMinWidth( 250 );


        HBox loadBox = new HBox();
        loadBox.setSpacing( 10 );
        loadBox.setPadding( new Insets( 5, 5, 5, 5 ) );
        TextField loadField = new TextField();
        Label loadedSuccessfully = new Label( "" );

//Savebutton function, save file as entered filename via Filemanager
        Button loadButton = new Button( "Load" );
        loadButton.setOnAction( actionEvent -> {
            FileManager fileManager = new FileManager( shapeHolder );
            try {
                String fileName = loadField.getText();
                if (!fileName.isEmpty()) {
                    try {
                        fileManager.readFromFile( fileName );
                        loadedSuccessfully.setText( "Successfully loaded en added to shape-list!" );
                        loadField.clear();
                    } catch (Exception e) {
                        loadedSuccessfully.setText( "File " + fileName + " is not found: " );
                    }
                } else {
                    loadField.clear();
                    loadedSuccessfully.setText( "(No filename to load)" );
                }
            } catch (Exception e) {
                loadField.clear();
                loadedSuccessfully.setText( e.getMessage() );
            }
        } );

        loadBox.getChildren().addAll( loadField, loadButton );
        vBox.getChildren().addAll( labelLoad, loadLabel, loadBox, loadedSuccessfully );
        return vBox;
    }
}
