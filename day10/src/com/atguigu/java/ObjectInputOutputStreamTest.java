package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * @author xiewei
 * @create 2022-07-18 14:06
 */
public class ObjectInputOutputStreamTest {
    @Test
    public void testOnjectOutputStream()
    {


        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            objectOutputStream.writeObject(new String("我爱北京"));
            Person p=new Person("xiewei",25);
            objectOutputStream.writeObject(p);
            p.setAge(22);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testObjectInputStream()
    {
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object o = ois.readObject();
            String tmp=(String)o;
            Person p=(Person)(ois.readObject());

            System.out.println(p);
            System.out.println(tmp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
