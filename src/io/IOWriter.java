package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by darcy on 2018/2/11.
 */
public class IOWriter {

    public static void main(String[] args) throws FileNotFoundException {
        String dir = System.getProperty("user.dir");
        PrintWriter out = new PrintWriter(dir + "\\src\\io\\io3.txt");
        out.println("test1");
        out.write("test2");
        out.close();

    }

}
