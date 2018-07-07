package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryTest {

    private static final String queryByAgeString = "select * from girl where age = ? ";

    public static void main(String[] args) {
        int age = 22;
        queryByAge(age);
    }

    private static void queryByAge(int age) {
        try {
            try (Connection connection = JDBCTest.getConnection()){
                PreparedStatement preparedStatement = connection.prepareStatement(queryByAgeString);
                preparedStatement.setInt(1, age);
                ResultSet resultSet = preparedStatement.executeQuery();
                ExecSQL.showResultSet(resultSet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            for (Throwable throwable : e) {
                throwable.printStackTrace();
            }
        }

    }

}
