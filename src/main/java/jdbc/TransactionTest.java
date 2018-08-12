package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {

    public static void main(String[] args) throws IOException, SQLException {
        testTransaction();
        batchUpdate();
    }

    public static void testTransaction() throws IOException, SQLException {
        try(Connection connection = JDBCTest.getConnection()){
            connection.setAutoCommit(false);
            // statment 可以用于多个不同的sql，但是只能有一个打开的结果集
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into girl(age, cup_size) values (20, 'D')");
            //            int i = 1 / 0;
            statement.executeUpdate("insert into girl(age, cup_size) values (20, 'E')");
            connection.commit();
        }
    }

    public static void batchUpdate() throws IOException, SQLException {
        try(Connection connection = JDBCTest.getConnection()){
            boolean autoCommit = connection.getAutoCommit();
            connection.setAutoCommit(true);
            Statement statement = connection.createStatement();
            for (int i = 0; i < 5; i++){
                statement.addBatch("insert into girl(age, cup_size) values ( "+(30 + i)+", 'E')");
            }
            statement.executeBatch();
            connection.setAutoCommit(autoCommit);
        }
    }



}
