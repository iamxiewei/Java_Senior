package com.atguigu.java;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的区别
 * @author xiewei
 * @create 2022-07-05 21:34
 */
public class StringBufferBuilderTest {


    /*
    * String、StringBuffer、StringBuilder三者的异同
    * String:不可变的字符序列;底层使用char[]存储
    * StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
    * StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储
    *
    *
    * 源码分析:
    *
    * */

    @Test
    public void test1()
    {
        StringBuffer sb1=new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);




    }
}
