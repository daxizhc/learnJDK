package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by darcy on 2018/2/9.
 */
public class IOStreamTest {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"\\src\\io\\io.txt");

//        StringBuffer sb = new StringBuffer();
//        byte[] bits = new byte[1024];
//        int len = 0;
//        while ((len = in.read(bits))!= -1){
//            sb.append(new String(bits,0,len));
//        }
//        System.out.println(sb);

//        int bit;
//        while ((bit = in.read())!=-1){
//            System.out.println(bit);
//        }
        in.close();

        FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir")+"\\src\\io\\io.dat");
        DataOutputStream dout = new DataOutputStream(fout);
        dout.write(0);
        dout.write(0);
        dout.write(0);
        dout.write(12);
        dout.writeInt(13);
        dout.close();

        FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\io\\io.dat");
        DataInputStream din = new DataInputStream(fin);
        int i = din.readInt();
        System.out.println(i);
        i = din.readInt();
        System.out.println(i);

        InputStreamReader inr = new InputStreamReader(System.in);
        System.out.println(inr.read());

    }

}
