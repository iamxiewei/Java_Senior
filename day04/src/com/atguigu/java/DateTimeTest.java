package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * jdk 8之前的时期时间API测试
 * 1、
 * @author xiewei
 * @create 2022-07-06 20:12
 */
public class DateTimeTest {
    /*
    *   SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    *   1、两个操作：
    *   1.1格式化：日期--》字符串
    *   1.2解析：格式化的逆过程，字符串-->日期
    *
    * */


    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期-->字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);   //Wed Jul 06 20:17:05 CST 2022
        System.out.println(format);//22-7-6 下午8:17

        //解析：格式化的逆过程，字符串
//        String str="2019-08-09";
//        Date parse1 = sdf.parse(str);
//        System.out.println(parse1);

        //*****************************
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String format1 = sdf1.format(date);
        System.out.println(format1);

        Date parse = sdf1.parse(format1);
        System.out.println(parse);

    }

    /*练习一：字符串"2020-09-08转换为java.sql.Date"*/
    @Test
    public void testExer() throws ParseException {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String str="2020-09-08";
        Date parse1 = sdf2.parse(str);
        java.sql.Date birthDate=new java.sql.Date(parse1.getTime());
        System.out.println(birthDate);
    }

    /*练习二：“三天打鱼，两天晒网”  1990-01-01 xxxx-xx-xx
    * 举例：2020-09-08
    * 总天数 % 5 == 1,2,3 :打渔
    * 总天数 % 5 == 4,0 :晒网
    *总天数的计算？
    * 方式一： (dat2.getTime()-date1.getTime())/(1000*60*60*24)+1
    * 方式二：1990-01-01  -->2019-12-31 +2020-01-01-->2020-09-08
    * */

        /*
        * Calendar日历类（抽象类）的使用
        *
        * */
    @Test
        public void testCalendar() throws ParseException {
            //1.实例化
            //方式一：创建其子类的对象
            //方式二：调用其静态方法getInstance()
            Calendar calendar = Calendar.getInstance();
            System.out.println(calendar.getClass());

            //2.常用方法
            //get()
            int days=calendar.get(calendar.DAY_OF_MONTH);
            System.out.println(days);
            System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

            //set()
            calendar.set(calendar.DAY_OF_MONTH,22);
            int days1=calendar.get(calendar.DAY_OF_MONTH);
            System.out.println(days1);

            //add()
            calendar.add(calendar.DAY_OF_MONTH,3);
            int days2=calendar.get(calendar.DAY_OF_MONTH);
            System.out.println(days2);

            //getTime():日历类-->
            Date time = calendar.getTime();
            System.out.println(time);

            //setTime():Date-->日历类，输入一个日期，输出该日期在该年有多少天
            String cal="2020-01-01";
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = s.parse(cal);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        }

        @Test
    public void testcalendar()
        {
            Date date=new Date();
            SimpleDateFormat formater=new SimpleDateFormat();
            System.out.println(formater.format(date));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 EEEHH:mm:ss");
            System.out.println(formater.format(date));

            try {
                Date date2 = simpleDateFormat.parse("2008年08月08日 星期一 08:08:08");
                String format = simpleDateFormat.format(date2);
                System.out.println(date2);
                System.out.println(format);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
}
