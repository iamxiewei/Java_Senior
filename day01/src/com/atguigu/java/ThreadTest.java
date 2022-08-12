package com.atguigu.java;

/**
 * @author xiewei
 * @create 2022-07-03 16:58
 */


class MyThread extends Thread{

    @Override
    public void run() {
        for(int i=0;i<100;i++)
        {
            if(i%2==0)
            {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName()+":"+"hello");
    }
}
