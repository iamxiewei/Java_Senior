package com.atguigu.java1;

/**
 * 懒汉式
 * @author xiewei
 * @create 2022-07-04 15:28
 */
public class BankTest {
}

class Bank{

    private Bank(){}

    private static Bank instance=null;

    public static Bank getInstance(){
        //方式一
        if(instance==null){
            synchronized (Bank.class) {
                if(instance ==null)
                    instance=new Bank();

            }
        }
        return instance;

    }

}
