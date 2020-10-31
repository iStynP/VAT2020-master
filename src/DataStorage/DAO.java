package DataStorage;

import Domain.ShapeDB;

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
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        double radius = resultSet.getDouble(3);
        double length = resultSet.getDouble(4);
        double width = resultSet.getDouble(5);
        double height = resultSet.getDouble(6);

        return new ShapeDB( id,name, radius, length, width, height);
    }


    public void save(ShapeDB shapeDB) {
        useStatement("insert.txt into shape value (?, ?)", statement -> {
            statement.setInt(1, shapeDB.getId());
            statement.setString(2, shapeDB.getName());
            statement.setDouble(3, shapeDB.getRadius());
            statement.setDouble(4, shapeDB.getLength());
            statement.setDouble(5, shapeDB.getWidth());
            statement.setDouble(6, shapeDB.getHeight());

            return statement.execute();
        });
    }


    public ShapeDB search(int id) {
        return useStatement("select id from shape where id = ?", statement -> {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery("select id from shape where id = id");

            if (resultSet.next()) {
                return recordToEntity(resultSet);
            } else {
                return null;
            }
        });
    }


    public ArrayList<ShapeDB> getAll() {
        return useStatement("select * from 'shape'", statement -> {
            ResultSet resultSet = statement.executeQuery("select * from shape");
            ArrayList<ShapeDB> result = new ArrayList<>();

            while (resultSet.next()) {
                ShapeDB shapeDB = recordToEntity(resultSet);
                result.add(shapeDB);
            }

            return result;
        });
    }


    public void delete(ShapeDB shapeDB) {
        throw new UnsupportedOperationException();
    }


    public void delete(int id) {
        throw new UnsupportedOperationException();
    }


    public void deleteAll() {
        throw new UnsupportedOperationException();
    }
}


