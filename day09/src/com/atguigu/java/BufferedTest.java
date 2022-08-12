package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 处理流：缓冲流的使用
 *
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * @author xiewei
 * @create 2022-07-14 15:26
 */
public class BufferedTest {
    /*
    * 实现非文本的复制*/
    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1.造文件
            File srcFile=new File("爱情与友情.jpg");
            File destFile=new File("爱情与友情3.jpg");
            //2.造流，节点流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取和写入
            byte[] buffer=new byte[10];
            int len;
            while((len=bis.read(buffer))!=-1)
            {
                bos.write(buffer,0,len);
//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos!=null)
            {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null)
            {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略
//        fos.close();
//        fis.close();
        }
    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath)
    {
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1.造文件
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);
            //2.造流，节点流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取和写入
            byte[] buffer=new byte[10];
            int len;
            while((len=bis.read(buffer))!=-1)
            {
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos!=null)
            {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null)
            {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered()
    {
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\15347\\Desktop\\01.mp4";
        String destPath = "C:\\Users\\15347\\Desktop\\03.mp4";


//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";

        copyFileWithBuffered(srcPath,destPath);


        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//1746
    }

    /*
    * 使用BufferedReader和BufferedWriter实现文本文件的复制
    *
    * */

    @Test
    public void testBufferedReaderBufferedWriter()
    {
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            //创建文件和相应的流
            br=new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw=new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一：使用char[] 数组
//            char[] cbuf=new char[1024];
//            int len;
//            while((len=br.read(cbuf))!=-1)
//            {
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }
            String data;
            while ((data=br.readLine())!=null)
            {
                //方法一：
//                bw.write(data+'\n');
                //方法二：
                bw.write(data);
                bw.newLine();   //提供换行的操作
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
