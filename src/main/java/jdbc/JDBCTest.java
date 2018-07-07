package jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTest {

    public static void main(String[] args) throws IOException, SQLException {
        runTest();
    }

    public static void runTest() throws IOException, SQLException {
        try(Connection conn = getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement("select * from girl where 1 =1 ");
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getObject(1) + "\t" + resultSet.getObject(2) +
                "\t" + resultSet.getObject(3));
            }
        }
    }

    public static Connection getConnection() throws IOException, SQLException {
        Properties props = new Properties();
        Path path = Paths.get("/Users/zhanghaochen/Documents/ideaproject/learnJDK/src/main/java/jdbc");
        props.load(Files.newInputStream(path.resolve("jdbc.properties")));
//        try {
//            Class.forName(props.getProperty("jdbc.drivers"));
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.setProperty("jdbc.drivers", props.getProperty("jdbc.drivers"));
        return DriverManager.getConnection(props.getProperty("jdbc.url"),
                props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
    }



}
