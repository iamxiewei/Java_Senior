package com.atuguigu.exer;

/**
 * @author xiewei
 * @create 2022-07-10 10:38
 */
public class MyDate implements Comparable{
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        MyDate o1 = (MyDate) o;
        int minusYear=this.getYear()-o1.getYear();
        if(minusYear!=0)
        {
            return minusYear;
        }
        int minusMonth=this.getMonth()-o1.getMonth();
        if(minusMonth!=0)
        {
            return minusMonth;
        }
        return this.getDay()-o1.getDay();

    }

    }

