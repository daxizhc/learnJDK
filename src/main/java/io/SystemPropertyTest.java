package io;

public class SystemPropertyTest {

    public static void main(String[] args) {
        // 加上-Dfile.encoding=utf-8 可以设置该参数
        // 加上-encoding utf-8 可以设置编译时参数
        System.out.println("file.encoding:"+System.getProperty("file.encoding"));
        System.out.println("sun.jnu.encoding:"+System.getProperty("sun.jnu.encoding"));
    }

}
