package com.atuguigu.exer;

import org.junit.Test;

import java.util.*;

/**
 * @author xiewei
 * @create 2022-07-10 10:41
 */
public class EmployeeTest {
    @Test
    public void test1()
    {
        TreeSet set=new TreeSet() ;

        Employee e1=new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2=new Employee("zhangxueyou",43,new MyDate(1965,5,4));
        Employee e3=new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4=new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5=new Employee("liangchaowei",55,new MyDate(1978,12,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        iterator.forEachRemaining(System.out::println);
    }

    @Test
    public void test2()
    {
        TreeSet set=new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                    if(o1 instanceof Employee && o2 instanceof Employee)
                    {
                        Employee e1=(Employee) o1;
                        Employee e2=(Employee) o2;

                        MyDate b1 = e1.getBirthday();
                        MyDate b2 = e2.getBirthday();

//                        int minusYear=b1.getYear()-b2.getYear();
//                        if(minusYear!=0)
//                        {
//                            return minusYear;
//                        }
//                        int minusMonth=b1.getMonth()-b2.getMonth();
//                        if(minusMonth!=0)
//                        {
//                            return minusMonth;
//                        }
//                        return b1.getDay()-b2.getDay();

                        return b1.compareTo(b2);


                    }
                    throw new RuntimeException("传入的数据类型不一致");
            }
        });

        Employee e1=new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2=new Employee("zhangxueyou",43,new MyDate(1965,5,4));
        Employee e3=new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4=new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5=new Employee("liangchaowei",55,new MyDate(1978,12,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        set.iterator().forEachRemaining(System.out::println);
    }


    @Test
    public void test3()
    {
        List list=new ArrayList();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        List list2=duplicate(list);
        list2.iterator().forEachRemaining(System.out::println);

    }

    private List duplicate(List list) {
        Set set=new HashSet();
        set.addAll(list);
        return new ArrayList(set);

    }

    @Test
    public void test4()
    {
        HashSet set=new HashSet();
        Person p1=new Person(1001,"AA");
        Person p2=new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        p1.name="CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001,"CC"));     //Person的实例对象计算HashCode值与原来的p1不同，所以可以添加
        System.out.println(set);
        set.add(new Person(1001,"AA"));     //Person的实例对象计算HashCode值与原来的p1相同，但是调用equals方法时，与修改后的p1值不相等，所以可以添加
        System.out.println(set);

    }
}
