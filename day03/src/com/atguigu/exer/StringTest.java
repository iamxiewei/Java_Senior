package com.atguigu.exer;

/**
 * @author xiewei
 * @create 2022-07-05 16:55
 */
public class StringTest {
//    String str=new String("good");
    String str="good";
    char[] ch={'t','e','s','t'};


    public void change(String str,char ch[])
    {
        System.out.println(str.hashCode());
        str="test ok";
        System.out.println(str.hashCode());
        ch[0]='b';
    }

    public static void main(String[] args) {
        StringTest ex=new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str.hashCode());
        System.out.println(ex.str+" and ");
        System.out.println(ex.ch);
    }



}
