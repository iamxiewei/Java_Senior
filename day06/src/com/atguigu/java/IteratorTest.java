package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用Iterator接口
 * @author xiewei
 * @create 2022-07-08 17:10
 */
public class IteratorTest {
    @Test
    public void test1()
    {
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator it=coll.iterator();

//        System.out.println(it.next());
        //理解Iterator执行的原理
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }


    @Test
    public void test2()
    {
        //这部分是重点
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);


        //错误方式1：
//        Iterator iterator=coll.iterator();
//        while((iterator.next()!=null))
//        {
//            System.out.println(iterator.next());
//        }

        //错误方式2：
        while(coll.iterator().hasNext())
        {
            System.out.println(coll.iterator().next());
        }
    }

    @Test
    public void test3()
    {
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext())
        {
            Object obj= iterator.next();
            if("Tom".equals(obj))
            {
                iterator.remove();
            }
        }

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

}
