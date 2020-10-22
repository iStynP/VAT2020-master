package DataStorage;


import Domain.Square;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Rodney
 */
public class DatabaseConnection {

    //Database settings
    private static String url = "jdbc:mysql://localhost:3306/vat2020";
    private static String user = "root";
    private static String password = "";
    private Connection connection;
    private Statement statement;


    public DatabaseConnection() {
        connection = null;
        statement = null;
    }

    public boolean openConnection() {
        boolean result = false;


        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);

                if (connection != null) {
                    statement = connection.createStatement();
                }

                result = true;
            } catch (
                    SQLException e) {
                System.out.println(e);
                result = false;
            }
        } else {
            result = true;
        }
        return result;
    }

    public boolean connectionIsOpen() {
        boolean open = false;

        if (connection != null && statement != null) {
            try {
                open = !connection.isClosed() && !statement.isClosed();
            } catch (SQLException e) {
                System.out.println(e);
                open = false;
            }
        }
        // Else, at least one the connection or statement fields is null, so
        // no valid connection.

        return open;
    }

    public void closeConnection() {
        try {
            statement.close();

            // Close the connection
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}