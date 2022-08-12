package com.atguigu.exer2;

import java.io.File;

/**
 * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 	拓展1：并计算指定目录占用空间的大小
 * 	拓展2：删除指定文件目录及其下的所有文件
 * @author xiewei
 * @create 2022-07-13 17:06
 */
public class ListFilesTest {
    public static void main(String[] args) {
        // 递归：文件目录
        //**打印出指定目录所有文件名称，包括子文件目录中的文件*/

        //1.创建目录对象
        File dir=new File("D:\\io\\io1");
        //通过递归实现
//        printSubFile(dir);
        //通过循环实现
        File[] subfiles=dir.listFiles();
        for(File f: subfiles)
        {
            long directorySize = getDirectorySize(f);
            System.out.println(directorySize);

        }
    }

    private static void printSubFile(File dir) {
        //打印目录下的子文件
        File[] subfiles=dir.listFiles();

        for(File f: subfiles)
        {
            if(f.isDirectory())
            {
                printSubFile(f);
            }else{
                System.out.println(f.getAbsoluteFile());
            }
        }
    }

    public static void listSubFiles(File file)
    {
        if(file.isDirectory())
        {
            String[] all=file.list();
            for(String s:all)
            {
                System.out.println(s);
            }
        }else{
            System.out.println(file + "是文件！");
        }
    }

    //拓展1：求指定目录所在空间的大小
    //求任意一个目录的总大小
    public static long getDirectorySize(File file)
    {
        //file是文件，那么直接返回file.length()
        //file是目录，把它的下一级的所有大小加起来就是它的总大小
        long size=0;
        if(file.isFile())
        {
            size+=file.length();
        }
        else{
            File[] all=file.listFiles();
            for(File f:all)
            {
                size+=getDirectorySize(f);
            }
        }
        return size;
    }
}
