package io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

public class MemoryMapTest {

    public static long checksumMappedFile(Path fileName) throws IOException {
        try (FileChannel channel = FileChannel.open(fileName)){
            CRC32 crc = new CRC32();
            int length = (int) channel.size();
            ByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
            for(int p = 0; p < length; p++){
                int c = byteBuffer.get(p);
                crc.update(c);
            }
            return crc.getValue();
        }
    }

    public static long checksumInputStream(Path fileName) throws IOException {
        try (InputStream inputStream = Files.newInputStream(fileName)){
            CRC32 crc32 = new CRC32();
            int c;
            while ((c = inputStream.read()) != -1){
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }


    public static void main(String[] args) throws IOException {
        Path deskTop = Paths.get("/Users/zhanghaochen/Desktop");
        Path todo = deskTop.resolve("todo");
        long start = System.currentTimeMillis();
        long crcVale = checksumMappedFile(todo);
        long end = System.currentTimeMillis();
        System.out.println("by mapped file: ");
        System.out.println(crcVale);
        System.out.println(end - start);
        start = System.currentTimeMillis();
        crcVale = checksumInputStream(todo);
        end = System.currentTimeMillis();
        System.out.println("by inputstream: ");
        System.out.println(crcVale);
        System.out.println(end - start);
    }

}
