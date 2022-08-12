package com.atguigu.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author xiewei
 * @create 2022-07-12 16:29
 */
public class DAOTest {

    @Test
    public void test1()
    {
        CustomerDAO dao1=new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list=dao1.getForList(10);


    }
}
