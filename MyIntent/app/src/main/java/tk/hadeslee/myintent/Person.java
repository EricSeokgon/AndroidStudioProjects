package tk.hadeslee.myintent;

import java.io.Serializable;

/**
 * Created by sklee on 2015-09-22.
 */
public class Person implements Serializable {

    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
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
