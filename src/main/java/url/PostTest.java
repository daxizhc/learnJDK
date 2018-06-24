package url;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class PostTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/zhanghaochen/Documents/ideaproject/learnJDK/src/main/java/url");
        Path props = path.resolve("post.properties");

        // load inputstream into properties
        Properties properties = new Properties();
        try(InputStream in = Files.newInputStream(props)){
            properties.load(in);
        }

        String url = properties.remove("url").toString();
        String result = doPost(url, properties);
        System.out.println(result);
    }

    public static String doPost(String urlString, Map<Object, Object> nameValuePairs) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        try (PrintWriter out = new PrintWriter(connection.getOutputStream())){
            StringBuffer postString = new StringBuffer();
            for (Map.Entry<Object, Object> nameValue : nameValuePairs.entrySet()) {
                postString.append(nameValue.getKey()).append("=").append(nameValue.getValue()).append("&");
            }
            postString.deleteCharAt(postString.length() - 1);
            System.out.println("post:" + postString.toString());
            out.print(postString.toString());
        }

        StringBuffer resultString = new StringBuffer();
        try (InputStreamReader in = new InputStreamReader(connection.getInputStream())){
            int c;
            while ((c = in.read()) != -1){
                resultString.append((char)c);
            }
        }
//        try (Scanner in = new Scanner(connection.getInputStream())){
//            while (in.hasNextLine()){
//                resultString.append(in.nextLine());
//                resultString.append("\n");
//            }
//        }
        return resultString.toString();
    }
}
