package regularexpression;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefMatchTest {

    public static void main(String[] args) throws IOException {
        // 匹配网页
        String urlString = "http://java.sun.com";

        InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());
        StringBuffer sb = new StringBuffer();
        int i ;
        while ((i = in.read()) != -1){
            sb.append((char)i);
        }
        String input = sb.toString();

        String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            String subString = input.substring(start, end);
            System.out.println(subString);
        }

        // split
        pattern = Pattern.compile("\\s*\\p{Punct}\\s*");
        input = "hello,zhc";
        String[] strings = pattern.split(input);
        System.out.println(strings[0]);
        System.out.println(strings[1]);
    }
}
