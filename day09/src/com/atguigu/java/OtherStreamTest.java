package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 1.标准的输入、输出流
 * 1.1
 * System.in:标准的输入流，默认从键盘输入
 * System.out:标准的输出流，默认从控制台输出
 * 1.2
 * System类的setIn(InputStream is) /setOut(PrintStream ps)方式重新指定输入和输出的流
 * 1.3练习：
 *     从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
 *     直至当输入“e”或者“exit”时，退出程序。
 *
 *     方法一：使用Scanner实现，调用next()返回一个字符串
 *     方法二：使用System.in实现。System.in  --->  转换流 ---> BufferedReader的readLine()
 * @author xiewei
 * @create 2022-07-15 21:06
 */
public class OtherStreamTest {
    public static void main(String[] args) {
//        BufferedReader br=null;
//        try{
//            InputStreamReader isr=new InputStreamReader(System.in);
//            br=new BufferedReader(isr);
//            while (true)
//            {
//                System.out.println("请输入字符串： ");
//                String data=br.readLine();
//                if("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data))
//                {
//                    System.out.println("程序结束");
//                    break;
//                }
//                String upperCase=data.toUpperCase();
//                System.out.println(upperCase);
//            }
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//        finally {
//            if(br!=null)
//            {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String s1 = s.toUpperCase();
        System.out.println(s1);


    }

    @Test
    public void test2()
    {
        PrintStream ps=null;
        FileOutputStream fos= null;
        try {
            fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ps=new PrintStream(fos,true);
        if(ps!=null)
        {
         System.setOut(ps);
        }

        for(int i=0;i<=255;i++)
        {
            System.out.println((char)i);
            if(i%50==0)
            {
                System.out.println();
            }
        }
        ps.close();
    }

    @Test
    public void test3()
    {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);         //转换流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String s = bufferedReader.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
