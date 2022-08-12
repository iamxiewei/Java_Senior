package com.atguigu.java;

/**
 * @author xiewei
 * @create 2022-07-07 16:42
 */
public class Goods implements Comparable{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String name;
    private double price;

    public Goods()
    {

    }
    public Goods(String name,double price)
    {
        this.name=name;
        this.price=price;
    }


    @Override
    public String toString() {
        return "Goods{"+"name='"+name+'\''+", price="+price+'}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods)
        {
            Goods goods=(Goods) o;
            //方式一：
            if(this.price>goods.price) {
                return 1;
            }else if(this.price<goods.price)
            {
                return -1;
            }
            else{
                return -this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException("传入的数据类型不一致!");
    }
}
