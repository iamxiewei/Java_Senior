package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author xiewei
 * @create 2022-07-13 11:23
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file=new File("D:\\io\\io1\\hello.txt");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destFile=new File(file.getParent(),"haha.txt");
        boolean newFile=destFile.createNewFile();
        if(newFile)
        {
            System.out.println("创建成功");
        }

    }

    @Test
    public void test2()
    {
        File file1=new File("hello.txt");
        File file2=new File("D:\\io\\hi.txt");

        boolean renameTo=file2.renameTo(file1);
        System.out.println(renameTo);
    }

    @Test
    public void test3()
    {
        File file1=new File("D:\\io\\io1\\io2\\io3");
        boolean mkdir = file1.mkdirs();
        System.out.println(mkdir);
    }


    @Test
    public void test4()
    {
        Map<String,Integer> map=new HashMap<>();
        map.put("aaa",123);
        map.put("bbb",456);
        map.put("ccc",789);

        Set<String> keySet=map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        Collection<Integer> values = map.values();
        Iterator<Integer> iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String,Integer> entry=iterator2.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "--->" + value);
        }

        ArrayList<?> list=new ArrayList<>();
        Collection<?> values1 = map.values();
        values1.forEach(System.out::println);


    }

    @Test
    public void test5() throws IOException {
        File file1=new File("D:\\io\\io1\\hello.txt");
        File file2=new File(file1.getParent(),"hello_.txt");
        System.out.println(file2.createNewFile());
    }

}
