package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * /---Map:
 *      /--
 *
 * @author xiewei
 * @create 2022-07-10 16:07
 */
public class MapTest {
    @Test
    public void test2()
    {
        Map map=new HashMap();

        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);

        Map map1=new HashMap();

    }

    @Test
    public void test3()
    {
        Map map=new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        //修改
        map.put("AA",87);
        System.out.println(map);

        Map map1=new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map.putAll(map1);
        
        System.out.println(map);
        
        //remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //clear
        map.clear();
        System.out.println(map);
    }

    @Test
    public void test4()
    {
        Map map=new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        System.out.println(map.get(455));
        boolean isExit = map.containsKey("BB");
        System.out.println(isExit);

        isExit=map.containsValue(123);
        System.out.println(isExit);
    }

    @Test
    public void test5()
    {
        Map map=new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        Set set=map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        //遍历所有的value集：values()
        Collection values=map.values();
        for(Object obj:values)
            System.out.println(obj);

        //遍历所有的key-value
        //entrySet():
        Set entrySet=map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry= (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }
}
