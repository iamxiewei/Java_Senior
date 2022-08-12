package com.atguigu.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：java中的对象，正常情况下，只能进行比较操作==或!=，不能使用>或<的
 * 但是在开发场景中，我么你需要对多个对象进行排序
 * 如何实现？使用两个接口中的任何一个：Comparable或Comparator接口
 * 二、comparable接口的使用
 * @author xiewei
 * @create 2022-07-07 16:11
 */
public class CompareTest {
    @Test
    public void test1()
    {
        String[] arr=new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr);
    }

    @Test
    public void test2()
    {
        Goods[] arr=new Goods[5];
        arr[0]=new Goods("lenovoMouse",34);
        arr[1]=new Goods("lenovoMouse",43);
        arr[2]=new Goods("lenovoMouse",12);
        arr[3]=new Goods("lenovoMouse",65);
        arr[4]=new Goods("lenovoMouse",43);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test3()
    {
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 instanceof String && o2 instanceof String)
                {
                    String s1=(String) o1;
                    String s2=(String) o2;
                    return s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4()
    {
        Goods[] arr=new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("huaweiMouse",224);
        arr[5] = new Goods("microsoftMouse",43);

        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1 instanceof Goods && o2 instanceof Goods)
                {
                    Goods g1=(Goods)o1;
                    Goods g2=(Goods)o2;
                    if(g1.getName().equals(g2.getName()))
                    {
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }
                    else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test5() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);

    }

    @Test
    public void test6() {
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
//         System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));

    }

}
