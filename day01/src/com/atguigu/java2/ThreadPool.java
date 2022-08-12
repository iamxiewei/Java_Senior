package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xiewei
 * @create 2022-07-05 10:38
 */

class NumberThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=100;i++)
        {
            if(i%2==0)
            {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<=100;i++)
        {
            if(i%2!=0)
            {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池

        ExecutorService service= Executors.newFixedThreadPool(10);      //设定线程池中线程的个数
        ThreadPoolExecutor service1=(ThreadPoolExecutor) service;    //向下转型

        //设定线程池的属性
        System.out.println(service.getClass()); // class java.util.concurrent.ThreadPoolExecutor
        service1.setCorePoolSize(15);   //设定核心池的大小
//        service1.setKeepAliveTime(100);
        //2.执行指定的线程操作。需要提供实现Runable接口或者Callable接口实现类的对象
        service.execute(new NumberThread());
        service.execute(new NumberThread1());

        //3.关闭线程池
        service.shutdown();


    }




}
