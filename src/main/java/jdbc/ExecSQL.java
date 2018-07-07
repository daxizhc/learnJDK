package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExecSQL {

    public static void main(String[] args) throws IOException {
        try{
            Scanner in = new Scanner(System.in);
//            括号内的资源必须实现java.lang.AutoCloseable
            try (Connection connection = JDBCTest.getConnection()){
                Statement stat = connection.createStatement();
                while (true){
                    System.out.println("Enter command or EXIT to exit:");
                    if(!in.hasNextLine())return;
                    String line = in.nextLine();
                    if(line.equalsIgnoreCase("EXIT"))return;
                    if(line.trim().endsWith(";")){
                        line = line.trim();
                        line = line.substring(0, line.length() -1 );
                    }
                    try {
                        boolean isResult = stat.execute(line);
                        if (isResult) {
                            ResultSet resultSet = stat.getResultSet();
                            showResultSet(resultSet);
                        } else {
                            int updateCount = stat.getUpdateCount();
                            System.out.println("UpdateCount:" + updateCount);
                        }
                    }catch (SQLException e){
                        for (Throwable throwable : e) {
                            throwable.printStackTrace();
                        }
                    }
                }
            }
        }catch (SQLException e){
            for (Throwable throwable : e) {
                throwable.printStackTrace();
            }
        }
    }

    public static void showResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for(int i = 1; i <= columnCount; i++){
            System.out.print(metaData.getColumnName(i)+"\t");
        }
        System.out.println();
        while (resultSet.next()){
            for(int i = 1; i <= columnCount; i++){
                System.out.print(resultSet.getObject(i));
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}
