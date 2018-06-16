package io;

public class SystemPropertyTest {

    public static void main(String[] args) {
        System.out.println("file.encoding:"+System.getProperty("file.encoding"));
        System.out.println("sun.jnu.encoding:"+System.getProperty("sun.jnu.encoding"));
    }

}
