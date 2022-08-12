package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 *
 * 涉及到String类与其他结构之间的转换
 * @author xiewei
 * @create 2022-07-05 20:44
 */
public class StringTest1 {

    /*
    * 复习：
    * String 与基本数据类型、包装类的转换
    * String -->基本数据类型、包装类；代用包装类的静态方法：parseXxx(str)
    * 基本数据类型、包装类--》String：代用String重载的valueof(xxx)
    * */
    @Test
    public void test1()
    {
        String str1="123";
        int num=Integer.parseInt(str1);


    }

    @Test
    /*
    * String 与char[]之间的转换
    * String-->char数组之间的转换
    *char[]-->String:调用String的构造器
    * */
    public void test2()
    {
        String str1="abc123";
        char[] charArr=str1.toCharArray();
        for(int i=0;i<charArr.length;i++)
        {
            System.out.println(charArr[i]);
        }

        char[] arr=new char[]{'h','e','l','l','o'};
        String str2=new String(arr);
        System.out.println(str2);

    }

    /*String与Byte[]之间的转换
    *String-->byte[]: 调用String的getBytes()
    * byte[]-->String
    * */


    /*
    * 编码：字符串--》字节（看得懂---》看不懂的二进制数据）
    * 解码：编码的逆过程，字节--》字符串（看不懂的二进制数据转化成--》看得懂）
    * */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1="abc123中国"; //UTF-8一个汉字占三位
        byte[] bytes = str1.getBytes();     //使用默认的字符集，进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk"); //使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("************************");
        String str2 = new String(bytes);    //使用默认的字符集进行解码
        System.out.println(str2);

        String s = new String(gbks);
        System.out.println(s);  //出现乱码。编码集与解码集不一致！

        String str4=new String(gbks,"gbk");
        System.out.println(str4);

    }


}
