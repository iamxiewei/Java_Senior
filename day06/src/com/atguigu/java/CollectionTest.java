package com.atguigu.java;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author xiewei
 * @create 2022-07-08 15:51
 */
public class CollectionTest {
    @Test
    public void test1()
    {
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
//        System.out.println(coll.contains(new Person("Jerry", 20)));
        coll.add(new Person("Jerry", 20));
        boolean contains=coll.contains(123);
        //contains(Object obj)：判断当前集合中是否包含obj
        //判断会调用自定义类中是否为调用equal方法
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry", 20)));     //Person类里没有重写equal方法
    }

    @Test
    public void test2()
    {
        //remove()从当前集合中移除obj元素
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
//        System.out.println(coll.contains(new Person("Jerry", 20)));
        coll.add(new Person("Jerry", 20));
        coll.remove(new Person("Jerry", 20));
        System.out.println(coll);

        //4.removeAll(Collectio coll1):从当前集合中移除coll1中所有的元素
        Collection coll1= Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3()
    {
        //retainAll求交集
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //retainAll(Collection coll1)：交集：获取当前集合和coll1集合的交集
//        Collection coll1= Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //equals(Object obj)
        Collection coll1=new ArrayList();   //也会调用Person中重写的equals方法，如果coll1顺序与coll不一样，那么就返回fasle，因为arrayList有序可重复
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("Jerry",20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));


    }
    @Test
    public void test4()
    {
       Collection coll=new ArrayList();
       coll.add(123);
       coll.add(456);
       coll.add(new Person("Jerry",20));
       coll.add(new String("Tom"));
       coll.add(false);
        //返回当前对象的哈希值
       System.out.println(coll.hashCode());

       //集合-->转换为数组
        Object[] arr = coll.toArray();
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        //拓展：数组-->集合：代用Arrays类的静态方法asList()
        Collection<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        //这种情况List会认为为一个元素
//        List arr1=Arrays.asList(new int[]{123,456});

        List ints = Arrays.asList(123, 456);
        System.out.println(ints);

        List<Integer> integers = Arrays.asList(new Integer[]{123,456});
        System.out.println(integers);
    }


}
