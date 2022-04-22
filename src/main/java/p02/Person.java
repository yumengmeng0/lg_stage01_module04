package p02;

import p01.AgeException;

import java.io.Serializable;

/**
 * @author: ymm
 * @date: 2022/4/18
 * @version: 1.0.0
 * @description:
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 7241091746341567038L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        setName(name);
        setAge(age);
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
