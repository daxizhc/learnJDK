package persistence;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * XMLEncoder requires JavaBeans object to serialize it,
     * so you have to define a public default constructor (with no arguments).
     */
    public Student() {
    }
}
