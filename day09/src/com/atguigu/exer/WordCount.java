package com.atguigu.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xiewei
 * @create 2022-07-14 16:32
 */
public class WordCount {
    @Test
    public void testWordCount()
    {
        FileReader fr=null;
        BufferedWriter bw=null;
        try {
            //1.创建Map集合
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            //2.遍历每一个字符，每一个字符出现的次数放到map中
            fr = new FileReader("dbcp.txt");
            int c = 0;
            while ((c = fr.read()) != -1) {
                //int 还原char
                char ch = (char) c;
                //判断char是否在map中第一次出现
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }

            //3.把map中数据存在文件count.txt
            //3.1创建Writer
            bw = new BufferedWriter(new FileWriter("wordcount.txt"));

            //3.2遍历map，再写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                switch (entry.getKey()) {
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t':  //\t表示tab键字符
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r'://
                        bw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bw.newLine();
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally {
            //4.关流
            if(fr!=null)
            {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw!=null)
            {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    @Test
    public void test1()
    {
        FileReader fr= null;
        FileWriter fw= null;
        try {
            fr = new FileReader("dbcp.txt");
            Map<Character,Integer> map=new HashMap<>();
            int c=0;
            char ch;
            while((c=fr.read())!=-1)
            {
                ch = (char) c;
                //判断char是否在map中第一次出现
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }

            fw = new FileWriter("wordcount1.txt");
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for(Map.Entry<Character, Integer> entry:entrySet)
            {
                fw.write(entry.getKey()+"="+entry.getValue()+"\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
}
