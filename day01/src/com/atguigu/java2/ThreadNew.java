package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。 ---JDK 5.0新增
 * 1、call()可以有返回值
 * 2、call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3、Callable是支持泛型的
 * @author xiewei
 * @create 2022-07-05 10:02
 */



class NumThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++)
        {
            if(i%2==0)
            {
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread=new NumThread();
        FutureTask futureTask=new FutureTask(numThread);
        new Thread(futureTask).start();

        Object sum= null;
        try {
            sum = futureTask.get();         //回调函数
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("总和为： "+sum);
    }
}
