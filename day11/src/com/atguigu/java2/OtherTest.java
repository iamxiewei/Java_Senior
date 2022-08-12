package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author xiewei
 * @create 2022-07-20 15:37
 */
public class OtherTest {


    @Test
    public void test1() throws NoSuchMethodException {
        Class clazz=Person.class;
        //getConstructors():获取当前运行时类中声明为public 的构造器
        Constructor[] constructors=clazz.getConstructors();
        for (Constructor c:constructors)
        {
            System.out.println(c);
        }
        System.out.println();

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c:declaredConstructors)
        {
            System.out.println(c);
        }

    }

    /*
    * 获取运行时类的父类
    *
    *
    * */

    @Test
    public void test2()
    {
        Class clazz=Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
    
    @Test
    public void test3()
    {
        Class clazz=Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();

        ParameterizedType paramType = (ParameterizedType) genericSuperclass;

        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();

//        for(Type t:actualTypeArguments)
//        {
//            System.out.println(t);
//        }

        String typeName = actualTypeArguments[0].getTypeName();
        System.out.println(typeName);


    }

    /*
    * 获取运行时类实现的接口
    *
    * */

    @Test
    public void test5()
    {
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();
        for(Class c:interfaces)
        {
            System.out.println(c);
        }
        System.out.println();

        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for(Class c:interfaces1)
        {
            System.out.println(c);
        }


    }


    /*
    * 获取运行时类所在的包
    *
    * */
    @Test
    public void test6()
    {
        Class clazz=Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }



    /*
    * 获取运行时类声明的注解
    *
    * */
    @Test
    public void test7(){
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annos : annotations){
            System.out.println(annos);
        }
    }




}



    

