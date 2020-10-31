package View;

import BusinessLogic.FileManager;
import Domain.Shape;
import Domain.ShapeHolder;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class LoadView extends Node {
    VBox vBox;
    HBox hBox;
    ShapeHolder shapeHolder;

    public VBox loadFile(ShapeHolder shapeHolder) {
        // HBox in VBox: Load to shapeHolder (list)
        VBox vBox = new VBox();

        Label labelLoad = new Label( "Load shapes from text here" );
        Label loadLabel = new Label( "Enter filename to load:" );
        vBox.setPadding( new Insets( 5, 5, 5, 5 ) );
        vBox.setSpacing( 5 );
        vBox.setMinWidth( 250 );
        vBox.setMinHeight( 175 );


        HBox loadBox = new HBox();
        loadBox.setSpacing( 10 );
        loadBox.setPadding( new Insets( 5, 5, 5, 5 ) );
        TextField loadField = new TextField();
        Label loadedSuccessfully = new Label( "" );

        //Buttons for add or replacement of the shape-list
        HBox addOrReplaceButtons = new HBox(  );
        addOrReplaceButtons.setPadding( new Insets( 5 ) );
        addOrReplaceButtons.setSpacing( 5 );
        Button addButton = new Button( "Add shapes to list" );
        Button replaceButton = new Button( "Replace all shapes" );
        addOrReplaceButtons.getChildren().addAll( addButton, replaceButton );
        addOrReplaceButtons.setVisible( false );


        //Load function, load file as entered filename via FileManager
        AtomicReference<Boolean> load = new AtomicReference<>( true );
        Button loadButton = new Button( "Load" );
        loadButton.setOnAction( actionEvent -> {
            FileManager fileManager = new FileManager(  );
            try {
                String fileName = loadField.getText();
                if (!fileName.isEmpty()) {
                    try {

                            ArrayList<Shape> shapeArrayList = fileManager.deSerialization( fileName + ".ser" );
                            //Add retrieved Objects to shapeHolder
//                        this.shapeHolder.retrieve(shapeArrayList);
                            if (shapeArrayList.isEmpty()) {
                                loadedSuccessfully.setText( "This list is empty" );
                            } else {
//                            loadField.setVisible( false );
//                            loadButton.setVisible( false );
                                addOrReplaceButtons.setVisible( true );
                                loadButton.setVisible( false );

                                addButton.setOnAction( actionEvent1 -> {
                                    shapeHolder.addFromSerializedList( shapeArrayList );
                                    loadedSuccessfully.setText( "Shapes from file added to list" );
                                    LoadView loadView = new LoadView();
                                    loadView.loadFile( shapeHolder );
                                    loadField.setVisible( true );
                                    loadField.clear();
                                    loadButton.setVisible( true );
                                    addOrReplaceButtons.setVisible( false );
                                    loadButton.setVisible( true );
                                } );
                                replaceButton.setOnAction( actionEvent1 -> {
                                    shapeHolder.replaceFromSerialized( shapeArrayList );
                                    LoadView loadView = new LoadView();
                                    loadView.loadFile( shapeHolder );
                                    loadedSuccessfully.setText( "List is replaced by Shapes from file" );
                                    loadField.setVisible( true );
                                    loadField.clear();
                                    loadButton.setVisible( true );
                                    addOrReplaceButtons.setVisible( false );
                                    loadButton.setVisible( true );
                                } );

                                loadedSuccessfully.setText( "Add shapes from file to list or replace list?" );
                            }
//
//                        shapeHolder.replace( shapeArrayList );
//
//                        loadedSuccessfully.setText( "Successfully loaded and loaded to shape-list!" );
//                        loadField.clear();


                    } catch (Exception e) {
                        loadedSuccessfully.setText( "File " + fileName + " is not found: " );
                        addOrReplaceButtons.setVisible( false );
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
        vBox.getChildren().addAll( labelLoad, loadLabel, loadBox, loadedSuccessfully, addOrReplaceButtons );
        return vBox;
    }
}
