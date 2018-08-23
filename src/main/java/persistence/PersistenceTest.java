package persistence;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PersistenceTest {

    // 比对象序列化使用空间更加小，会消除冗余
    @Test
    public void testWrite() throws IOException {
        Path path = Paths.get("/Users/zhanghaochen/Documents/ideaproject/learnJDK/src/main/java/persistence");
        FileOutputStream fileOutPutStream = new FileOutputStream(Files.createFile(path.resolve("student.xml")).toFile());
        XMLEncoder out = new XMLEncoder(fileOutPutStream);
        out.writeObject(new Student("zhangsan", 12));
        out.close();
    }

}
