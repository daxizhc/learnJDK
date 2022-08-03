package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {


    public static void main(String args[]) {
        testEnglishStart();
    }

    private static void testEnglishStart() {
        Pattern pattern = Pattern.compile("^[a-zA-z]+");
        System.out.println(pattern.matcher("test123").find());
        System.out.println(pattern.matcher("123test123").find());
        System.out.println(pattern.matcher("Test123").find());
    }



    private static void testDouYin() {
        String str = "2.82 nda:/ 复制打开抖音，看看【最江阴评论部的作品】盘点全国停贷楼盘# 大v说 # 大v说热点 https://v.douyin.com/22UNfvX/";
        //2.82 nda:/ 复制打开抖音，看看【最江阴评论部的作品】盘点全国停贷楼盘# 大v说 # 大v说热点 https://v.douyin.com/22UNfvX/
//        String str = "https://v.douyin.com/NcMKkaQ/";
//        str = str.substring(str.indexOf("https://v.douyin.com"));
        String pattern = "(.*)(https://v.douyin.com/\\S+/)(.*)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            System.out.println(m.group(2));
        }

        System.out.println(m.matches());
    }

}
