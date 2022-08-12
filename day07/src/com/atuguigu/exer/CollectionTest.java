package com.atuguigu.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author xiewei
 * @create 2022-07-10 9:56
 */
public class CollectionTest {
    @Test
    public void test1()
    {
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(123);
        coll.add(123);
        coll.add(123);

        coll.forEach(System.out::println);      //java 8新特性 方法引用
    }

    @Test
    public void test2()
    {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator =coll.iterator();
        while(iterator.hasNext())
        {
            Object obj=iterator.next();
            if("Tom".equals(obj))
            {
                iterator.remove();
            }
        }
        coll.forEach(System.out::println);


    }

}
