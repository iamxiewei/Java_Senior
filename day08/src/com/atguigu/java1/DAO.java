package com.atguigu.java1;

import java.util.List;

/**
 *
 *
 *
 * DAO:data(base) access object 数据访问对象
 * @author xiewei
 * @create 2022-07-12 16:23
 */
public class DAO<T> {
    //添加一条记录
    public void add(T t)
    {

    }

    //删除记录
    public boolean remove(int index)
    {
        return false;
    }

    //修改一条记录
    public void update(int index,T t)
    {

    }

    //查询一条记录
    public T getIndex(int index)
    {
        return null;
    }

    //查询多条记录
    public List<T> getForList(int index)
    {
        return null;
    }

    //泛型方法
    //举例：获取表中一共有多少条记录？获取最大的员工入职记录
    public <E> E getValue()
    {
        return null;
    }
}
