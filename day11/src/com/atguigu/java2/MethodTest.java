package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author xiewei
 * @create 2022-07-20 14:55
 */
public class MethodTest {
    @Test
    public void test1()
    {
        Class clazz= Person.class;

        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m:methods)
        {
            System.out.println(m);
        }


        System.out.println();
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods)
            System.out.println(m);

    }


    @Test
    public void test2()
    {
        Class clazz=Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m:declaredMethods)
        {
            //1.获取方法声明的注解
            Annotation[] annos=m.getAnnotations();
            for (Annotation a:annos)
            {
                System.out.print(a);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers())+"\t");

            //3.返回值类型
            System.out.print(m.getReturnType().getName()+"\t");

            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");

            //5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(parameterTypes.length>0)
            {
                for(int i=0;i<parameterTypes.length;i++)
                {
                    if(i==parameterTypes.length-1)
                    {
                        System.out.print(parameterTypes[i].getName()+" args_ "+i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName()+" args_ "+i+",");
                }
            }

            System.out.println(")");

            //6.跑出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length>0)
            {
                System.out.print("throws ");
                for(int i=0;i<exceptionTypes.length;i++)
                {
                    if(i==exceptionTypes.length-1)
                    {
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }

                    System.out.println(exceptionTypes[i].getName()+",");
                }
            }

            System.out.println();
        }


    }


}
