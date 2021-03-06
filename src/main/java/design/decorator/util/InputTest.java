package design.decorator.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

    public static void main(String[] args) throws IOException {
        int c;
        InputStream in = new LowerCaseInputStream(
                new BufferedInputStream(
                        new FileInputStream("/Users/zhanghaochen/Documents/ideaproject/learnJDK/src/main/java/design/decorator/util/test.txt")
                )
        );

        while ((c = in.read()) >= 0){
            System.out.print((char)c);
        }
    }


}

