package com.atguigu.java;

import org.junit.Test;

/**
 * @author xiewei
 * @create 2022-07-06 20:06
 */
public class IdeaDebug {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//

    }
}
