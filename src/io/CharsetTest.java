package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by darcy on 2018/2/11.
 */
public class CharsetTest {

    public static void main(String[] args) {
        //        可用的字符集
        //        SortedMap<String, Charset> csets = Charset.availableCharsets();
        //        for (String name : csets.keySet()) {
        //            System.out.println(name);
        //        }

        String greeting = "\u03C0\uD835\uDD6B";
        System.out.println(greeting);

        //        3个代码单元
        int n = greeting.length();
        System.out.println(n);

        //        2个代码点
        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(cpCount);

        //        用字符集编码Java字符串
        String str = "I";  //此java文件编码为utf8，我们看到的""内的内容，都是utf8解码后产生的
        Charset cset = Charset.forName("ascii");
        ByteBuffer byteBuffer = cset.encode(str);
        byte[] bytes = byteBuffer.array();
        System.out.println("length of byte array : " + bytes.length);
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();

        //        用字符集解码字节序列
        byteBuffer = ByteBuffer.wrap(bytes,0,bytes.length);
        CharBuffer charBuffer = cset.decode(byteBuffer);
        System.out.println(charBuffer.toString());

        String a = "知";
        System.out.println(a.length());

        int 张 = 1;
        System.out.println(张);


    }

}
