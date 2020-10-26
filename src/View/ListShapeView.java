package View;

import Domain.Shape;
import Domain.ShapeDB;
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

        javafx.scene.control.ListView<ShapeDB> listViewFromDB = new ListView<>();
        listViewFromDB.setItems( FXCollections.observableArrayList( shapeHolder.getAllFromDB() ) );

        //get All Names and properties Of Objects
        javafx.scene.control.ListView<String> listViewNames = new ListView<>();
        listViewNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesAndProperties() ) );

        javafx.scene.control.ListView<String> listViewFromDBNames = new ListView<>();
        listViewFromDBNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesFromDB() ) );

//refresh list
        Button refreshButton = new Button( "Refresh List" );
        refreshButton.setOnAction( actionEvent -> {
            listViewNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesAndProperties() ) );
        } );

        Button refreshButtonFromDB = new Button( "Refresh from DB" );
        refreshButton.setOnAction( actionEvent -> {
            listViewFromDBNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesFromDB()) );
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

        Button deleteFromDBButton = new Button( "Delete From DB" );
        deleteFromDBButton.setOnAction( actionEvent -> {
            //get IndexNr from listView (deleteNr)
            int deleteNr = listViewFromDBNames.getSelectionModel().getSelectedIndex();
            //get Shape from indexNr
            ShapeDB deleteShapeFromDB = shapeHolder.getShapeFromDB( deleteNr );
            //delete Shape from shapeHolder
            shapeHolder.deleteShapeFromDB( deleteShapeFromDB );
            //refresh viewlist
            listViewFromDB.setItems( FXCollections.observableArrayList( shapeHolder.getAllFromDB() ) );
            //refresh viewList with names and properties
            listViewFromDBNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesFromDB()) );
        } );

        refreshAndDeleteButtons.getChildren().addAll( refreshButton, refreshButtonFromDB,deleteButton, deleteFromDBButton );
        refreshAndDeleteButtons.setSpacing( 35 );

        listViewLayout.getChildren().addAll( listViewNames,listViewFromDBNames, refreshAndDeleteButtons );
        listViewLayout.setPadding( new Insets( 10 ) );
        listViewLayout.setSpacing( 10 );
        listView.setMaxWidth( 200 );

        return listViewLayout;
    }
}
