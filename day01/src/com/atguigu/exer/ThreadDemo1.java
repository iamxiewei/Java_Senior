package com.atguigu.exer;

/**
 * @author xiewei
 * @create 2022-07-03 19:11
 * join():在线程a中调用线程b的join()方法，此时线程a就进入阻塞状态，知道线程b完全执行完以后，线程a才结束阻塞状态。
 * sleep():
 */



public class ThreadDemo1 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<=100;i++)
                {
                    if(i%2==0)
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    if(i%10==0)
                        yield();    //释放当前cpu执行权
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<=100;i++)
                {
                    if(i%2!=0)
                        System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();
    }
}
