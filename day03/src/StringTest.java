import org.junit.Test;

/**
 * String的使用
 * @author xiewei
 * @create 2022-07-05 15:50
 */



public class StringTest {
    /*
    * String ：字符串，使用 对""引起来表示
    *1、String声明为final的不可被继承
    *2、String实现了Serializable接口，表示字符串是支持序列化。
    *         实现了Comparable接口：表示String可以比较大小
    * 3、String内部定义了final char[] value用于存储字符串数据
    * 4、String：代表不可变的字符序列。简称不可变性
    *   体现：1.当对字符串重新赋值时；需要重写指定内存区域值，
    *   2.当对现有字符串进行连接操作时，也需要重新
    *   3.当调用String的replace方法修改字符或字符串时，也必须重新指定内存区域赋值
    * 5、通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
    * 6、字符串常量池中是不会存储相同内容的字符串的。
    *
    * */
    @Test
    public void test1()
    {
        String s1="abc";    //字面量的定义方式
        String s2="abc";
        System.out.println(s1==s2);
        String s3="abc";
        s3+="def";
        System.out.println(s3);
        System.out.println(s2);

        String s4="abc";
        System.out.println(s4.hashCode());
        s4="bcd";
        System.out.println(s4.hashCode());
        System.out.println(s4);
        String s5=s4.replace("a","m");
        System.out.println(s5);
    }


    @Test
    public void test2()
    {
        //通过字面量定义的方式：此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中
        String s1="javaEE";
        String s2="javaEE";
        //通过new+构造器的方式：
        String s3=new String("javaEE");
        String s4=new String("javaEE");


        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));
    }





    @Test
    public void test3()
    {
        String s1="javaEE";
        String s2="hadoop";

        String s3="javaEEhadoop";
        String s4="javaEE"+"hadoop";
        String s5=s1+"hadoop";
        String s6="javaEE"+s2;
        String s7=s1+s2;


        System.out.println(s3 == s4);   //true
        System.out.println(s3 == s5);   //false
        System.out.println(s3 == s6);   //false
        System.out.println(s5 == s6);   //false
        System.out.println(s5 == s7);   //false

        String s8=s5.intern();
        System.out.println(s3 == s8);
    }


    @Test
    public void test4()
    {
        String s1="javaEEhadoop";
        String s2="javaEE";
        String s3=s2+"hadoop";
        System.out.println(s1 == s3);

        final String s4="javaEE";
        String s5=s4+"hadoop";
        System.out.println(s1 == s5);


    }



}
