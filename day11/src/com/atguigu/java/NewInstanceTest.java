package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/*
 * 通过反射创建对应的运行时类的对象
 *
 * @author xiewei
 * @create 2022-07-20 10:31
 */
public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class clazz=Person.class;
        /*
        * newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器
        *
        *要想此方法正常的创建运行时类的对象，要求：
        *1.运行时类必须提供空参的构造器
        * 2.空参的构造器的访问权限得够。通常，设置为public
        *
        * 在javabean中要求提供一个public的空参构造器。原因：
        * 1.便于通过反射，创建运行时类的对象
        * 2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
        * */

        Person obj=(Person) clazz.newInstance();
        System.out.println(obj);
    }

    //体会反射的动态性
    @Test
    public void test2()
    {
        for (int i=0;i<100;i++)
        {
            int num=new Random().nextInt(3);
            String classPath="";
            switch(num)
            {
                case 0:
                    classPath="java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.atguigu.java.Person";
                    break;
            }

            Object obj= null;
            try {
                obj = getInstance(classPath);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            System.out.println(obj);


        }

    }

    private Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz=Class.forName(classPath);
        return clazz.newInstance();
    }


}
