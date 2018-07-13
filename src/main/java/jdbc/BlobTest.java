package jdbc;

import java.io.IOException;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BlobTest {

    public static void main(String[] args) throws IOException, SQLException {
        try(Connection connection = JDBCTest.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from blob_test where id = 1 ");
            ResultSet resultSet = statement.getResultSet();
            String result = "";
            while (resultSet.next()){
                Reader contentReader = resultSet.getCharacterStream("content");
                StringBuilder contentStringBuilder = new StringBuilder();
                char[] contentChar = new char[1024];
                int len;
                while ((len = contentReader.read(contentChar)) != -1){
                    contentStringBuilder.append(contentChar, 0, len);
                }
                System.out.println(result = contentStringBuilder.toString());
            }
            statement.close();
            System.out.println(result);

            Blob blob = connection.createBlob();
            blob.setBytes(1, result.getBytes());
            PreparedStatement preparedStatement = connection.prepareStatement("insert into blob_test(content) values (?) ");
            preparedStatement.setBlob(1, blob);
            int count = preparedStatement.executeUpdate();
            if(count > 0)
                System.out.println("suceess:"+ count);
            preparedStatement.close();
        }
    }

}
