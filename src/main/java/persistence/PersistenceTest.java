package persistence;

import java.beans.BeanInfo;
import java.beans.DefaultPersistenceDelegate;
import java.beans.Encoder;
import java.beans.Expression;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PersistenceDelegate;
import java.beans.PropertyDescriptor;
import java.beans.Statement;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;

import org.junit.Test;

public class PersistenceTest {

    public static final String basePath = "/Users/zhanghaochen/Documents/ideaproject/learnJDK/src/main/java/persistence";

    // 比对象序列化使用空间更加小，会消除冗余
    @Test
    public void testWrite() throws IOException {
        Path path = Paths.get("/Users/zhanghaochen/Documents/ideaproject/learnJDK/src/main/java/persistence");
        FileOutputStream fileOutPutStream = new FileOutputStream(Files.createFile(path.resolve("student1.xml")).toFile());
        XMLEncoder out = new XMLEncoder(fileOutPutStream);
        out.writeObject(new Student("zhangsan", 12));
        out.close();
    }

    // 持久化代理构造对象
    @Test
    public void testPersistenceDelegate() throws IOException {
        Path path = Paths.get(basePath);
        FileOutputStream fileOutPutStream = new FileOutputStream(Files.createFile(path.resolve("student2.xml")).toFile());
        XMLEncoder out = new XMLEncoder(fileOutPutStream);

        PersistenceDelegate delegate = new DefaultPersistenceDelegate() {
            @Override
            protected Expression instantiate(Object oldInstance, Encoder out) {
                Student s = (Student) oldInstance;
                return new Expression(oldInstance, Student.class, "new",
                        new Object[]{
                                s.getName(), s.getAge()
                        });
            }
        };

        out.setPersistenceDelegate(Student.class, delegate);
        out.writeObject(new Student("lisi", 16));
        out.close();
    }

    // 由属性构造对象
    @Test
    public void testpersistence1() throws IOException {
        Path path = Paths.get(basePath);
        FileOutputStream fileOutPutStream = new FileOutputStream(Files.createFile(path.resolve("student3.xml")).toFile());
        XMLEncoder out = new XMLEncoder(fileOutPutStream);

        out.setPersistenceDelegate(Student.class, new DefaultPersistenceDelegate(new String[]{"name", "age"}));
        out.writeObject(new Student("wangwu", 19));
        out.close();
    }

    @Test
    public void testpersistence2() throws IOException {
        Path path = Paths.get(basePath);
        FileOutputStream fileOutPutStream = new FileOutputStream(Files.createFile(path.resolve("student4.xml")).toFile());
        XMLEncoder out = new XMLEncoder(fileOutPutStream);

        out.writeObject(new Student("wangliu", 19));
        out.close();
    }

    // 根据工厂方法构造对象
    @Test
    public void testpersistence3() throws IOException {
        Path path = Paths.get(basePath);
        FileOutputStream fileOutPutStream = new FileOutputStream(Files.createFile(path.resolve("student5.xml")).toFile());
        XMLEncoder out = new XMLEncoder(fileOutPutStream);

        PersistenceDelegate delegate = new DefaultPersistenceDelegate() {
            @Override
            protected Expression instantiate(Object oldInstance, Encoder out) {
                return new Expression(oldInstance, InetAddress.class, "getByAddress",
                        new Object[]{((InetAddress) oldInstance).getAddress()});
            }
        };

        // 安装代理要针对子类
        out.setPersistenceDelegate(Inet4Address.class, delegate);
        out.writeObject(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}));
        out.close();
    }

    @Test
    public void testpersistence4() throws IOException {
        Path path = Paths.get(basePath);
        FileOutputStream fileOutPutStream = new FileOutputStream(Files.createFile(path.resolve("student6.xml")).toFile());
        XMLEncoder out = new XMLEncoder(fileOutPutStream);

        BitSet set = new BitSet(8);
        set.set(3);
        // 直接writeObject都为空
        // out.writeObject(set);

        PersistenceDelegate delegate = new DefaultPersistenceDelegate() {
            @Override
            protected void initialize(Class<?> type, Object oldInstance, Object newInstance, Encoder out) {
                super.initialize(type, oldInstance, newInstance, out);
                BitSet bs = (BitSet) oldInstance;
                for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
                    out.writeStatement(new Statement(bs, "set", new Object[]{i, i + 1, true}));
                }
            }
        };
        out.setPersistenceDelegate(BitSet.class, delegate);
        out.writeObject(set);
        out.close();
    }

    @Test
    // 禁止age属性被存档
    public void testpersistence5() throws IOException, IntrospectionException {
        Path path = Paths.get(basePath);
        FileOutputStream fileOutPutStream = new FileOutputStream(Files.createFile(path.resolve("student7.xml")).toFile());
        XMLEncoder out = new XMLEncoder(fileOutPutStream);
        BeanInfo info = Introspector.getBeanInfo(Student.class);
        for(PropertyDescriptor desc : info.getPropertyDescriptors()){
            if(desc.getName().equals("age")){
                desc.setValue("transient", Boolean.TRUE);
            }
        }
        out.writeObject(new Student("wangliu", 19));
        out.close();
    }
}