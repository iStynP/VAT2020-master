package DataStorage;
import Domain.ShapeDB;

import java.sql.*;


/**
 * @author Rodney
 */
public abstract class DatabaseConnection {

    //Database settings
    private static String url = "jdbc:mysql://localhost:3306/vat2020";
    private static String user = "root";
    private static String password = "";
    private Connection connection;
    protected Statement statement;



    @FunctionalInterface
    interface UsesStatement<R> {
        R apply(PreparedStatement statement) throws SQLException;
    }

    <R> R useStatement(String sql, UsesStatement<R> operator) {
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            //noinspection UnnecessaryLocalVariable
            R result = operator.apply(statement);

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    abstract ShapeDB recordToEntity(ResultSet resultSet) throws SQLException;
}
