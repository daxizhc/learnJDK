package io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

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
        BasicFileAttributes attributes = Files.readAttributes(todo, BasicFileAttributes.class);
        System.out.println(attributes.creationTime());

        // 1.6.6 迭代目录中的文件  try可保证流被关闭
        try(DirectoryStream<Path> desktopPaths = Files.newDirectoryStream(workPath, "*.java")){
            for (Path desktopPath : desktopPaths) {
                System.out.println(desktopPath);
            }
        }
        // TODO: 2018/6/10  并不打印目录
        Files.walkFileTree(workPath.resolve("tmp"), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(attrs.isDirectory()){
                    System.out.println("dictionary:" + file);
                }else {
                    System.out.println("file:" + file);
                }
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });

        Path tmpZip = workPath.resolve("tmp.zip");
        FileSystem fs = FileSystems.newFileSystem(Paths.get(tmpZip.toString()), null);
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return  FileVisitResult.CONTINUE;
            }
        });



    }


}
