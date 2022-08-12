package com.atguigu.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xiewei
 * @create 2022-07-14 16:13
 */
public class PicTest {


    //图片的加密
    @Test
    public void test1()
    {
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream(new File("爱情与友情.jpg"));
            fos = new FileOutputStream(new File("爱情与友情Secret.jpg"));

            byte[] buffer=new byte[20];

            int len;
            while((len=fis.read(buffer))!=-1)
            {
                //字节数组进行修改
                //错误的
                //正确地
                for(int i=0;i<len;i++)
                {
                    buffer[i]=(byte)(buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //图片的解密
    @Test
    public void test2()
    {
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream(new File("爱情与友情Secret.jpg"));
            fos = new FileOutputStream(new File("爱情与友情解密.jpg"));

            byte[] buffer=new byte[20];

            int len;
            while((len=fis.read(buffer))!=-1)
            {
                //字节数组进行修改
                //错误的
                //正确地
                for(int i=0;i<len;i++)
                {
                    buffer[i]=(byte)(buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}




