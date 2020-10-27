package DataStorage;

import Domain.*;

import java.sql.*;
import java.util.ArrayList;



public class Database {
    ArrayList<Shape> shapeDBList;

    public Database(ArrayList<Shape> shapeDBList) {
        this.shapeDBList = shapeDBList;
    }

    private static String url = "jdbc:mariadb://localhost:3306/sport";
    private static String user = "root";
    private static String password = " ";


    public void list() {
        try {
            //First retrieve all the properties of the shapes
            //STEP 2: Register JDBC driver
            Class.forName ("org.mariadb.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection( "jdbc:mariadb://localhost:3306/vat2020", user, password )) {
                try (Statement statement = connection.createStatement()) {
                    ResultSet resultSet = statement.executeQuery( "select * from clubs" );

                    while (resultSet.next()) {
                        String name = resultSet.getString( "name" );
                        double radius = resultSet.getDouble( "radius" );
                        double length = resultSet.getDouble( "length" );
                        double width = resultSet.getDouble( "width" );
                        double height = resultSet.getDouble( "height" );

                        switch (name) {
                            case "circle":
                                Circle circle = new Circle( radius );
                                shapeDBList.add( circle );
                                break;
                            case "square":
                                Square square = new Square( length, width );
                                shapeDBList.add( square );
                                break;
                            case "triangle":
                                Triangle triangle = new Triangle( length, width, height );
                                shapeDBList.add( triangle );
                                break;
                            case "sphere":
                                Sphere sphere = new Sphere( radius );
                                shapeDBList.add( sphere );
                                break;
                            case "block":
                                Block block = new Block( length, width, height );
                                shapeDBList.add( block );
                                break;
                            case "cylinder":
                                Cylinder cylinder = new Cylinder( radius, height );
                                shapeDBList.add( cylinder );
                                break;
                        }

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
//            System.out.println( "Something went wrong" );
//            System.out.println(e.getMessage());
        }

    }
}
