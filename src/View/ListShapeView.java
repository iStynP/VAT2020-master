package View;

import DataStorage.DAO;
import Domain.Shape;
import Domain.ShapeDB;
import Domain.ShapeHolder;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        HBox addAndDeleteFromDBButtons = new HBox(  );

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

        //Add Shape to DB
        Button addShapeToDB = new Button ("Add shape to DB");
        addShapeToDB.setOnAction( actionEvent -> {
            //Convert shape into ShapeDB
            int shapeNr = listViewNames.getSelectionModel().getSelectedIndex();
            //get Shape from indexNr
            Shape shapeFromList = shapeHolder.getShape( shapeNr );
            ShapeDB shapeForDB = new ShapeDB( shapeFromList.getNameOfShape(), shapeFromList.getRadius(), shapeFromList.getLength(), shapeFromList.getWidth(), shapeFromList.getHeight() );
            DAO dao = new DAO();
            dao.save( shapeForDB );
        } );

        //Delete Shape from DB
        //Add Shape to DB
        Button deleteShapeFromDB = new Button ("Delete shape from DB");
        deleteShapeFromDB.setOnAction( actionEvent -> {
            //Convert shape into ShapeDB
            int shapeNr = listViewNames.getSelectionModel().getSelectedIndex();
            //get Shape from indexNr
            Shape shapeFromList = shapeHolder.getShape( shapeNr );
            ShapeDB shapeForDB = new ShapeDB( shapeFromList.getNameOfShape(), shapeFromList.getRadius(), shapeFromList.getLength(), shapeFromList.getWidth(), shapeFromList.getHeight() );
            DAO dao = new DAO();
            dao.delete( shapeForDB );
        } );

        //Get objects from DB
        Button shapesFromDB = new Button( "Get all Shapes from DB" );
        shapesFromDB.setMinWidth( 240 );
        shapesFromDB.setOnAction( actionEvent -> {
            shapeHolder.getFromDB();
            //        listViewNames.setItems( FXCollections.observableArrayList( shapeHolder.getAllNamesAndProperties() ) );
        } );

        //Get objects from DB
        Button deleteAllFromButton = new Button( "Delete all Shapes from DB" );
        deleteAllFromButton.setMinWidth( 240 );
        deleteAllFromButton.setOnAction( actionEvent -> {
            DAO dao = new DAO();
            dao.deleteAll();
        } );

        //DB Buttons in an Hbox
        addAndDeleteFromDBButtons.getChildren().addAll( addShapeToDB );

        Label labelDatabase = new Label( "DataBase options:" );

        refreshAndDeleteButtons.getChildren().addAll( refreshButton, deleteButton );
        refreshAndDeleteButtons.setSpacing( 5 );

        listViewLayout.getChildren().addAll( listViewNames, refreshAndDeleteButtons, labelDatabase, addAndDeleteFromDBButtons, shapesFromDB, deleteAllFromButton );
        listViewLayout.setPadding( new Insets( 10 ) );
        listViewLayout.setSpacing( 10 );
        listView.setMaxWidth( 200 );

        return listViewLayout;
    }
}
