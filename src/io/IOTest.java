package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by darcy on 2018/2/9.
 */
public class IOTest {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        InputStream in = new FileInputStream(System.getProperty("user.dir")+"\\src\\io\\io.txt");
        StringBuffer sb = new StringBuffer();
//        byte[] bits = new byte[1024];
//        int len = 0;
//        while ((len = in.read(bits))!= -1){
//            sb.append(new String(bits,0,len));
//        }
//        System.out.println(sb);
        int bit;
        while ((bit = in.read())!=-1){
            System.out.println(bit);
        }



    }

}
