package com.atguigu.java;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author xiewei
 * @create 2022-07-19 21:53
 */
public class ClassLoaderTest {
    @Test
    public void test1()
    {
        ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        ClassLoader classLoader2=classLoader1.getParent();
        System.out.println(classLoader2);

        System.out.println(String.class.getClassLoader());
    }


    /*
    *
    * Properties:用来读取配置文件
    *
    * */
    @Test
    public void test2() throws Exception {
        Properties pros=new Properties();

        //此时的文件默认在当前的module下。
        //读取配置文件的方式一：
//        FileInputStream fis=new FileInputStream("jdbc1.properties");
//        pros.load(fis);


        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为： 当前module的src下
        ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
        InputStream is=classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        System.out.println("user =" + user + ",password =" + password);
    }
}
