package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollAndUpdatableTest {

    public static void main(String[] args) throws IOException, SQLException {
        try(Connection connection = JDBCTest.getConnection()){
            String sql = "select * from girl where 1 = 1 ;";
            //
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("initail:" + resultSet.getRow());
            resultSet.next();
            System.out.println("next:" + resultSet.getRow());
            resultSet.relative(4);
            System.out.println("5th:" + resultSet.getRow());
            resultSet.previous();
            System.out.println("4th:" + resultSet.getRow());
            resultSet.absolute(3);
            System.out.println("3rd:" + resultSet.getRow() + "\tage:" + resultSet.getObject("age"));
            resultSet.first();
            System.out.println("1st:" + resultSet.getRow());
            resultSet.last();
            System.out.println("last:" + resultSet.getRow());
            System.out.println("========================");
            resultSet.updateString("cup_size", "H");
            resultSet.updateRow();
            // sensitive
            System.out.println("3rd:" + resultSet.getRow() + "\tage:" + resultSet.getObject("age"));

            // insert
            resultSet.moveToInsertRow();
            resultSet.updateInt("age", 15);
            resultSet.updateString("cup_size", "A");
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
            System.out.println("after insert:" + resultSet.getRow());

            // delete
            resultSet.next();
            resultSet.deleteRow();

        }
    }


}
