package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author xiewei
 * @create 2022-07-14 18:13
 */
public class InputStreamReaderTest {
    @Test
    /*
    * 此时处理异常的话，仍然应该使用try-catch-finally
    * InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
    *
    *
    *
    * */
    public void test1()
    {
        InputStreamReader isr=null;
        try {
            FileInputStream fis=new FileInputStream("dbcp.txt");

            isr=new InputStreamReader(fis,"UTF-8");

            char[] cbuf=new char[20];
            int len;
            while ((len=isr.read(cbuf))!=-1)
            {
                String str=new String(cbuf,0,len);
                System.out.print(str);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2()
    {
        InputStreamReader isr=null;
        OutputStreamWriter osw=null;
        try {
            //1.造文件、造流
            File file1=new File("dbcp.txt");
            File file2=new File("dbcp_gbk.txt");

            FileInputStream fis=new FileInputStream(file1);
            FileOutputStream fos=new FileOutputStream(file2);

            isr=new InputStreamReader(fis,"utf-8");
            osw=new OutputStreamWriter(fos,"utf-8");

            //2.读写过程
            char[] cbuf=new char[20];
            int len;
            while ((len=isr.read(cbuf))!=-1)
            {
                osw.write(cbuf,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr!=null)
            {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null)
            {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
