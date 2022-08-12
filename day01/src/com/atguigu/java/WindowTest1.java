package com.atguigu.java;

/**
 * @author xiewei
 * @create 2022-07-04 10:46
 */


class Window1 implements Runnable{
    private int ticket =100;

    @Override
    public void run() {
        while(true)
        {
            synchronized (this)
            {
                if(ticket>0)
                {
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":卖票，票号： "+ticket);
                    ticket--;
                }
                else{
                    break;
                }
            }
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w=new Window1();

        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
