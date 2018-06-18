package url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");
        URLConnection urlConnection = url.openConnection();
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        for (String key : headerFields.keySet()) {
            System.out.print("key:" + key + "                       ");
            for (String fieldValue : headerFields.get(key)) {
                System.out.println("value:" + fieldValue);
            }
        }
    }

}
