package Main;

import BusinessLogic.FileManager;
import Domain.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import View.TwoDView;
import View.ThreeDView;

import java.io.FileWriter;
import java.text.DecimalFormat;

/**
 * @author Rodney
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

//            BorderPane layout = new BorderPane();
//            Label label = new Label( "Choose your new 2D-shape here" );
//            layout.setPadding( new Insets( 10 ) );
//
//            VBox shapeButtons2D = new VBox(  );
//            Button button = new Button( "Triangle" );
//            Button button1 = new Button("Circle");
//            Button button2 = new Button( "Square" );
//            shapeButtons2D.getChildren().addAll( button, button1, button2 );
//            shapeButtons2D.setPadding( new Insets( 10, 10, 10, 10 ) );
//            shapeButtons2D.setSpacing( 10 );
//
//            layout.setTop( label );
//            layout.setLeft( shapeButtons2D );


            // 3.1. Create the menu for the general layout
            Tab twoDShapes = new Tab( "2D-Shapes", twoDView.getView() );
            Tab threeDShapes = new Tab( "3D-Shapes", threeDView.getView() );

            layout.getTabs().addAll( twoDShapes, threeDShapes );




            // 5. First show the input View
            layout.getSelectionModel().select( twoDShapes );

            // 6. Create the main View and add the high level layout
            Scene scene = new Scene(layout, 400, 450);

            window.setScene(scene);
            window.show();

            // 7. Show the application
            window.show();

        }

        public static void main (String[]args) {
            try {
                launch( Main.class );
            } catch (Exception e) {
                System.out.println( e.getMessage() );
            }







//        Test Units
            ShapeHolder shapeHolder = new ShapeHolder();

            Triangle triangle = new Triangle( 5, 5, 5 );
            System.out.println( triangle );
            System.out.println( " " );
            Square square = new Square( 13, 35 );
            Square vk = new Square( 13, 35 );
            System.out.println( square );
            System.out.println( " " );
            Circle circle = new Circle( 3 );
            System.out.println( circle );
            Circle rondje = new Circle( 3 );
            Circle rond = new Circle( 3 );
            Circle round = new Circle( 3 );

//
//
            System.out.println( " " );
            shapeHolder.addShape( triangle );
            shapeHolder.addShape( square );
            shapeHolder.addShape( circle );
            shapeHolder.addShape( rondje );
            shapeHolder.addShape( rond );
            shapeHolder.addShape( round );
            shapeHolder.addShape( vk );
            String print = shapeHolder.print();
            System.out.println(print);

            shapeHolder.print(  );
            shapeHolder.printAllShapes();

//            FileManager fileManager = new FileManager( shapeHolder );
//            fileManager.writeToFile( "newText" );

//
//            Sphere bol = new Sphere( 3.6 );
//            Sphere bal = new Sphere( 5 );
////        System.out.println(bol.getVolume());
////        System.out.println(bal.getTotalSurface());
//
//            shapeHolder.addShape( bal );
//            shapeHolder.addShape( bol );
//
////        shapeHolder.print();
//
//            System.out.println( bol );
//
//            Block blok = new Block( 3, 5, 7 );
//            System.out.println( blok );
//            shapeHolder.addShape( blok );
//
//            shapeHolder.print();
//
//            Cylinder cylinder = new Cylinder( 5, 7 );
//            System.out.println( cylinder );
//
//            shapeHolder.addShape( cylinder );
//
//            shapeHolder.print();
        }
    }


