package View;

import Domain.Shape;
import Domain.ShapeHolder;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ListShapeView {
    private ShapeHolder shapeHolder;

    public ListShapeView(ShapeHolder shapeHolder) {
        this.shapeHolder = shapeHolder;
    }

    public VBox getView() {
        VBox listViewLayout = new VBox();
        HBox refreshAndDeleteButtons = new HBox();

        //get All Objects
        javafx.scene.control.ListView<Shape> listView = new ListView<>();
        listView.setItems( FXCollections.observableArrayList( shapeHolder.getAll() ) );

        //get All Names and properties Of Objects
        javafx.scene.control.ListView<String> listViewNames = new ListView<>();
        listViewNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesAndProperties() ) );

//refresh list
        Button refreshButton = new Button( "Refresh List" );
        refreshButton.setOnAction( actionEvent -> {
            listViewNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesAndProperties() ) );
        } );

        //Get objects from DB
        Button shapesFromDB = new Button( "Shapes from DB" );
        shapesFromDB.setOnAction( actionEvent -> {
            shapeHolder.getFromDB();
            listViewNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesAndProperties() ) );
        } );

        Button deleteButton = new Button( "Delete Shape" );
        deleteButton.setOnAction( actionEvent -> {
            //get IndexNr from listView (deleteNr)
            int deleteNr = listViewNames.getSelectionModel().getSelectedIndex();
            //get Shape from indexNr
            Shape deletedshape = shapeHolder.getShape( deleteNr );
            //delete Shape from shapeHolder
            shapeHolder.deleteShape( deletedshape );
            //refresh viewlist
            listView.setItems( FXCollections.observableArrayList( shapeHolder.getAll() ) );
            //refresh viewList with names and properties
            listViewNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesAndProperties() ) );
        } );

        refreshAndDeleteButtons.getChildren().addAll( refreshButton, deleteButton, shapesFromDB );
        refreshAndDeleteButtons.setSpacing( 5 );

        listViewLayout.getChildren().addAll( listViewNames, refreshAndDeleteButtons );
        listViewLayout.setPadding( new Insets( 10 ) );
        listViewLayout.setSpacing( 10 );
        listView.setMaxWidth( 200 );

        return listViewLayout;
    }
}
