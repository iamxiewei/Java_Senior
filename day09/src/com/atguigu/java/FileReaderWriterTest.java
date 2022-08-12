package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类             节点流                 缓冲流（处理流的一种）
 * InputStream          FileInputStream         BufferedInputStream
 * OutputStream         FileOutputStream        BufferedOutStream
 * Reader               FileReader              BufferedReader
 * Writer               FileWriter              BufferedWriter
 * @author xiewei
 * @create 2022-07-13 20:06
 */
public class FileReaderWriterTest {
    @Test
    public void test1() {
        //1.实例化File类实例化对象，指明要操作的文件
        File file = new File("hello.txt");
        //2.提供具体的流
        FileReader f2 = null;
        try {


            f2 = new FileReader(file);
            int data;
            while ((data = f2.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                f2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //3.数据的读入
//        int data = f2.read();
//        while (data!=-1)
//        {
//            System.out.println((char) data);
//            data=f2.read();
//        }

        //方式二：


        //4.流的关闭操作
    }

    @Test
    public void testFileReader1() {
        FileReader fr = null;
        //1.File类的实例化
        File file = new File("hello.txt");
        //2.FileReader流的实例化
        try {
            fr = new FileReader(file);
            //3.读入的操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                //4.资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*
     * 从内存中写出数据到硬盘的文件里
     *
     *    1. 输出操作，对应的File可以不存在的。并不会报异常
     *        2.
     *             File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
     *             File对应的硬盘中的文件如果存在：   如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
     *                                              如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
     */


    @Test
    public void testFileWriter() throws IOException {
        //1.提供File类的对象，致命写出到的文件
        File file = new File("hello1.txt");

        //2.提供FileWriter的对象，用于数据的写出
        FileWriter fw = new FileWriter(file, true);

        //3.写出的操作
        fw.write("I have a dream!\n");
        fw.write("you need to have a dream!");

        //4.流资源的关闭
        fw.close();
    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            //不能使用字符流处理图片等字节数据
            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * 实现对图片的复制
     *
     * */
    @Test
    public void testFileInputOutputStream() {
        File srcFile = new File("爱情与友情.jpg");
        File destFile = new File("爱情与友情1.jpg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //指定路径下的文件的复制

    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\15347\\Desktop\\01.mp4";
        String destPath = "C:\\Users\\15347\\Desktop\\02.mp4";


//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";

        copyFile(srcPath,destPath);


        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//2337

    }


}
