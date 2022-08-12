package com.atguigu.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xiewei
 * @create 2022-07-15 21:15
 */
public class MyInput {
        public static String readString()
        {
            BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
            String string="";
            try {
                string =br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return string;
        }

        public static int readInt()
        {
            return Integer.parseInt(readString());
        }

        public static double readDouble()
        {
            return Double.parseDouble(readString());
        }

        public static double readByte()
        {
            return Byte.parseByte(readString());
        }

        public static double readShort()
        {
            return Short.parseShort(readString());
        }
}
