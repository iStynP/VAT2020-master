package Main;

import DataStorage.DAO;
//import DataStorage.Database;
import DataStorage.DatabaseConnection;
import Domain.*;
import View.ThreeDView;
import View.TwoDView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Rodney & Stijn
 */

    public class Main extends Application {

    // 1. Create the model that the application uses
    private ShapeHolder shapeHolder;

        @Override
    public void init() throws Exception {
        this.shapeHolder = new ShapeHolder();

    }

        @Override
        public void start(Stage window) {

            // 2. Create the views ("subviews")
            TwoDView twoDView = new TwoDView(shapeHolder);
            ThreeDView threeDView = new ThreeDView(shapeHolder);

            // 3. Create the higher level layout
            TabPane layout = new TabPane(  );
            layout.setTabClosingPolicy( TabPane.TabClosingPolicy.UNAVAILABLE );

            // 4. Create the menu for the general layout using TabPanes
            Tab twoDShapes = new Tab( "2D-Shapes", twoDView.getView() );
            Tab threeDShapes = new Tab( "3D-Shapes", threeDView.getView() );

            layout.getTabs().addAll( twoDShapes, threeDShapes );

            // 5. First show the input View
            layout.getSelectionModel().select( twoDShapes );

            // 6. Create the main View and add the high level layout
            Scene scene = new Scene(layout, 600, 600);

            window.setScene(scene);
            window.show();

            // 7. Show the application
            window.show();

//            ArrayList<Shape> listFromDB = null;
//            Database db = new Database(listFromDB);
//            db.list();


        }

        public static void main (String[]args) {
            try {
                launch( Main.class );
            } catch (Exception e) {
                System.out.println( e.getMessage() );
            }

        }
    }


