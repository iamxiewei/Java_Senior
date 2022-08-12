package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 * @author xiewei
 * @create 2022-07-06 10:00
 */
public class DateTimeTest {


    @Test
    public void test1()
    {
        long l = System.currentTimeMillis();    //毫秒时间差时间戳
        System.out.println(l);
    }

    @Test
    public void test2()
    {
        Date date1 = new Date();
        System.out.println(date1);      //toString:获取当前的年、月、日、时、分、秒
        System.out.println(date1.getTime());    //获取当前Date对象对应的毫秒数

        //指定的时间构造器
        Date date2 = new Date(1657073217685L);
        System.out.println(date2);

        java.sql.Date date3=new java.sql.Date(1657073217685L);
        System.out.println(date3);

        //如何将util.Date对象转换为sql.date对象
        Date date4=new java.sql.Date(1657073217685L);
        java.sql.Date date5= (java.sql.Date) date4; //向下转型

        Date date6=new Date(1657073217685L);
        java.sql.Date date7=new java.sql.Date(date6.getTime());
        System.out.println(date7);
    }
}



