package com.atguigu.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额
 *
 * 分析：
 * 1、是否有多线程问题？是，两个储户线程
 * 2、是否有共享数据？有，账户（或账户余额）
 * 3、是否有线程安全问题？有
 * 4、需要考虑如何解决线程安全问题？同步机制：有三种方式
 * @author xiewei
 * @create 2022-07-04 20:22
 */

class Account{
    private double balance;
    public Account(double balance){
        this.balance=balance;
    }

    //存钱
    public void deposit(double amt)    //这里的synchronized同步锁的对象是this，也即调用同步方法的对象
    {
        if(amt>0)
        {
            balance+=amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":存钱成功。余额为： "+balance);
        }
    }
}


class Customer extends Thread{
    private Account acct;
    private static ReentrantLock lock = new ReentrantLock();

    public Customer(Account acct)
    {
        this.acct=acct;

    }

    @Override
    public void run() {
        synchronized (Customer.class){
            for(int i=0;i<3;i++)
            {
                acct.deposit(1000);
            }
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account(0);
        Customer c1=new Customer(acct);
        Customer c2=new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");
        System.out.println("修改");
        c1.start();
        c2.start();
    }
}
