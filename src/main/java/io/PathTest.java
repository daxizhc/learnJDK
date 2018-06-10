package io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PathTest {

    public static void main(String[] args) throws IOException {
        // 1.6.1 Path
        String baseDir = "/Users/zhanghaochen";
        Path basePath = Paths.get(baseDir);
        System.out.println(basePath);
        Path workPath = basePath.resolve("Desktop");
        System.out.println(workPath);
        Path tempPath = workPath.resolveSibling("Temp");
        System.out.println(tempPath);
        // 从workPath到tempPath的路径
        Path delt = workPath.relativize(tempPath);
        System.out.println(delt);
        System.out.println(workPath.resolve(delt));
        System.out.println(workPath.resolve(delt).normalize());

        // 1.6.2 读写文件
        Path todo = workPath.resolve("todo");
        byte[] bytes = Files.readAllBytes(todo);
        String content = new String(bytes, Charset.forName("utf8"));
        System.out.println(content);

        Path copyOfTodo = todo.resolveSibling("copyOfTodo");
        Files.write(copyOfTodo, content.getBytes( Charset.forName("utf8")));
        Files.write(copyOfTodo, "it is copy".getBytes(Charset.forName("utf8")), StandardOpenOption.APPEND);

        // 1.6.4 创建文件和目录
//        Path newDir = Files.createDirectory(workPath.resolve("newDir"));
//        Path newFile = Files.createFile(newDir.resolve("newFile.txt"));

        // 1.6.5 获取文件信息
        System.out.println(Files.size(todo));
        System.out.println(Files.isDirectory(todo));
        System.out.println(Files.getOwner(todo));

    }


}
