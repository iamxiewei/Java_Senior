package com.atguigu.java;

import java.util.Objects;

/**
 * @author xiewei
 * @create 2022-07-08 15:53
 */
public class Person {
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

    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private int age;

    @Override
    public boolean equals(Object o) {
        System.out.println("Person.equals...");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
