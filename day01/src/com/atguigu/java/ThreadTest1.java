package com.atguigu.java;

/**
 * 创建多线程的方式二：实现runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 * @author xiewei
 * @create 2022-07-03 20:25
 */


class MyThread2 implements Runnable
{
    @Override
    public void run() {
        for(int i=0;i<=100;i++)
        {
            if(i%2==0)
                System.out.println(i);
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
    }
}
