package DataStorage;

import Domain.Shape;
import Domain.ShapeDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodney
 */
public class DAO extends DatabaseConnection {


    @Override
    ShapeDB recordToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt( 1 );
        String name = resultSet.getString( 2 );
        double radius = resultSet.getDouble( 3 );
        double length = resultSet.getDouble( 4 );
        double width = resultSet.getDouble( 5 );
        double height = resultSet.getDouble( 6 );

        return new ShapeDB( name, radius, length, width, height );
    }


    public void save(ShapeDB shapeDB) {
        try {
            useStatement( "insert into shape (name, radius, length, width, height)" + "values (?, ?, ?, ?, ?)", preparedStatement -> {
                // 1st column (Id) is auto-incremented
                preparedStatement.setString( 1, shapeDB.getName() );
                preparedStatement.setDouble( 2, shapeDB.getRadius() );
                preparedStatement.setDouble( 3, shapeDB.getLength() );
                preparedStatement.setDouble( 4, shapeDB.getWidth() );
                preparedStatement.setDouble( 5, shapeDB.getHeight() );

                return preparedStatement.execute();
            } );
        } catch (Exception e) {
            System.out.println( e.fillInStackTrace() );
            System.out.println( e.getMessage() );
        }
    }


    public ShapeDB search(int id) {
        return useStatement( "select id from shape where id = ?", statement -> {
            statement.setInt( 1, id );

            ResultSet resultSet = statement.executeQuery( "select id from shape where id = id" );

            if (resultSet.next()) {
                return recordToEntity( resultSet );
            } else {
                return null;
            }
        } );
    }


    public ArrayList<ShapeDB> getAll() {
        return useStatement( "select * from 'shape'", statement -> {
            ResultSet resultSet = statement.executeQuery( "select * from shape" );
            ArrayList<ShapeDB> result = new ArrayList<>();

            while (resultSet.next()) {
                ShapeDB shapeDB = recordToEntity( resultSet );
                result.add( shapeDB );
            }

            return result;
        } );
    }


    public void delete(ShapeDB shapeDB) {
        try {
            useStatement( "delete from shape where name = ?, radius = ?, length = ?, width = ?, height = ?", preparedStatement -> {
                // 1st column (Id) is auto-incremented
//            statement.setInt(1, shapeDB.getId());
                preparedStatement.setString( 1, shapeDB.getName() );
                preparedStatement.setDouble( 2, shapeDB.getRadius() );
                preparedStatement.setDouble( 3, shapeDB.getLength() );
                preparedStatement.setDouble( 4, shapeDB.getWidth() );
                preparedStatement.setDouble( 5, shapeDB.getHeight() );

                return preparedStatement.execute();
            } );
        } catch (Exception e) {
            System.out.println( e.fillInStackTrace() );
            System.out.println( e.getMessage() );
        }
    }



    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

}


