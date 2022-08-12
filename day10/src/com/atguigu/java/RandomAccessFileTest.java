package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author xiewei
 * @create 2022-07-18 15:11
 */
public class RandomAccessFileTest {
    @Test
    public void test1()
    {
        RandomAccessFile raf1= null;
        RandomAccessFile raf2= null;
        try {
            raf1 = new RandomAccessFile(new File("爱情与友情.jpg"),"r");
            raf2 = new RandomAccessFile(new File("爱情与友情1.jpg"),"rw");

            byte[] buffer=new byte[1024];
            int len;
            while ((len=raf1.read(buffer))!=-1)
            {
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2()
    {
        RandomAccessFile raf1= null;
        try {
            raf1 = new RandomAccessFile("hello.txt","rw");
            raf1.write("xyz".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    @Test
    public void test3()
    {
        RandomAccessFile raf1= null;
        try {
            raf1 = new RandomAccessFile("hello.txt","rw");
            raf1.seek(3);
            System.out.println(new File("hello.txt").length());
            StringBuilder builder=new StringBuilder((int) new File("hello.txt").length());
            byte[] buffer=new byte[20];
            int len;
            while ((len=raf1.read(buffer))!=-1)
            {
                builder.append(new String(buffer,0,len));
            }
            raf1.seek(3);
            raf1.write("opq".getBytes());

            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}
