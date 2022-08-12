package com.atguigu.java;

/**
 * @author xiewei
 * @create 2022-07-11 15:12
 */
public class User implements Comparable{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public User(String name,int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User) {
            User user = (User) o;
            int compare = -this.name.compareTo(user.name);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.age, user.age);
            }
        }
        else throw new RuntimeException("输入的类型不匹配");
        }
    }

