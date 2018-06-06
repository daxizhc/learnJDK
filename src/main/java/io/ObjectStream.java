package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by darcy on 2018/2/12.
 */
public class ObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s = new Student("zhc",23);
        FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir")+"\\src\\io\\object.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);
        objectOutputStream.writeObject(s);
        objectOutputStream.close();

        FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\io\\object.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fin);
        Student s2 = (Student) objectInputStream.readObject();
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
    }


}

class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
