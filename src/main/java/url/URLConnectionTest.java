package url;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import sun.misc.BASE64Encoder;

public class URLConnectionTest {

    public static void main(String[] args) throws IOException {
        try{
            String urlName = "http://horstmann.com";
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();

            String username = "123";
            String password = "123";
            String input = username + ":" + password;
            String encoding = new BASE64Encoder().encode(input.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + encoding);

            connection.connect();
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()){
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    System.out.println(key + ": "+ value);
                }
            }

            System.out.println("----------");
            System.out.println("getContentType: "+ connection.getContentType());
            System.out.println("getContentLength: "+ connection.getContentLength());
            System.out.println("getContentEncoding: "+ connection.getContentEncoding());
            System.out.println("getDate: "+ connection.getDate());
            System.out.println("getExpiration: " + connection.getExpiration());
            System.out.println("getLastModified: "+ connection.getLastModified());
            System.out.println("----------");

            Scanner in = new Scanner(connection.getInputStream());

            for(int n = 1; in.hasNextLine() && n <= 10; n++){
                System.out.println(in.nextLine());
            }
            if(in.hasNextLine())
                System.out.println("...");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
