package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {


    public static void main(String args[]) {
        testPublishTime();
    }

    private static void testPublishTime() {
        String str = " <script type=\"text/javascript\" nonce=\"1075714159\" reportloaderror>var __INLINE_SCRIPT__=function(){\"use strict\";var e=function(e,n){var t=e;if(e.indexOf(\"——\")>-1){e=e.replace(/——/g,'<span style=\"letter-spacing:normal\">——</span>')}n&&(n.innerHTML=n.innerHTML.replace(t,e))};if(!window.__second_open__){e(\"深圳、广州、北京、上海、天津、重庆、南京、杭州、济南，2022年7月第四周房价数据出炉\",document.getElementById(\"activity-name\")),window.__setTitle=e}return e}();</script><script type=\"text/javascript\" nonce=\"1075714159\" reportloaderror>var __INLINE_SCRIPT__=function(){\"use strict\";var e=function(e,t,n,i){var _=new Date(1e3*(1*t)),o=function(e){return\"0\".concat(e).slice(-2)},r=_.getFullYear()+\"-\"+o(_.getMonth()+1)+\"-\"+o(_.getDate())+\" \"+o(_.getHours())+\":\"+o(_.getMinutes());i&&(i.innerText=r)};if(!window.__second_open__){e(0,\"1659511562\",0,document.getElementById(\"publish_time\")),window.__setPubTime=e}return e}();</script>";
        String pattern = "(.*)\"([0-9]+)\",0,document\\.getElementById\\(\"\"\\)(.*)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            System.out.println(m.group(2));
        }

    }



    private static void testEnglishStart() {
        Pattern pattern = Pattern.compile("^[a-zA-z]+.*");
        System.out.println(pattern.matcher("test123").matches());
        System.out.println(pattern.matcher("123test123").matches());
        System.out.println(pattern.matcher("Test123").matches());
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
