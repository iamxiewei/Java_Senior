package com.atguigu.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xiewei
 * @create 2022-07-19 19:42
 */
public class ReflectionTest {
    @Test
    public void test1()
    {
        Person p1=new Person("Tom",12);
        p1.age=10;
        System.out.println(p1.toString());
        p1.show();
    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons=clazz.getConstructor(String.class,int.class);
        Object obj=cons.newInstance("Tom",12);
        Person p=(Person) obj;
        System.out.println(p.toString());

        //2.通过反射，调用对象指定的属性、方法
        Field age=clazz.getDeclaredField("age");

        age.set(p,10);
        System.out.println(p.toString());

        Method show=clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("****************************************");
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Object jerry = cons1.newInstance("Jerry");
        Person p1=(Person) jerry;
        System.out.println(p1);

        //调用私有的属性
        Field name=clazz.getDeclaredField("name");
        Method setName = clazz.getDeclaredMethod("setName", String.class);
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);

        //调用私有的方法
        Method showNation=clazz.getDeclaredMethod("showNation",String.class);
        showNation.setAccessible(true);
        String nation=(String) showNation.invoke(p1,"中国");
        System.out.println(nation);

    }

    /*
    * 关于java.lang.Class类的理解
    * 1.类的加载过程
    * 程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)
    * 接着我么能使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程
    * 就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就作为class的一个实例。
    *
    * 2.换句话说，class的实例就对应着一个运行时类
    * 3.加载到内存中的运行时类，会缓存一定的时间。在此时间内，我们可以通过不用的方式来获取次运行时类
    *
    * */

    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性： .class
        Class clazz1=Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象，调用getClass()
        Person p1=new Person();
        Class clazz2=p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法： forName(String classPath)
        Class clazz3=Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);

        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader=ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1==clazz4);
    }


    @Test
    public void test4()
    {
        Class c1=Object.class;
        Class c2=Comparable.class;
        Class c3=String[].class;
        Class c4=int[][].class;
        Class c5= ElementType.class;
        Class c6=Override.class;
        Class c7=int.class;
        Class c8=void.class;
        Class c9=Class.class;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        int[] a=new int[8];
        int[] b=new int[100];
        Class c10=a.getClass();
        Class c11=b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

    public static void main(String[] args) {
        System.out.println(A.m);
    }

}

class A{
    static{
        int m=300;
    }
    static int m=100;
}
