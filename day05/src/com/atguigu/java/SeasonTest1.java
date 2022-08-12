package com.atguigu.java;

/**
 * 使用Enum关键字定义枚举类
 * 说明：定义的枚举类默认继承为java.lang.Enum类
 *
 * Enum类中的常用方法-valueOf
 * toString()
 * equals()
 * hashCode()
 * values()
 * valueOf
 * toString()
 * @author xiewei
 * @create 2022-07-07 20:27
 */
public class SeasonTest1 {
    public static void main(String[] args) {
//        Season1 s1=Season1.AUTUMN;
//        s1.show();
        System.out.println(season2.AUTUMN);
    }
}

interface Info
{
    void show();
}



enum season2{
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;
}
enum Season1 implements Info{

    //3、提供当前枚举类的多个对象：public static final
    SPRING("春天","春暖花开")
            {
                public void show()
                {
                    System.out.println(1);
                }
            },
    SUMMER("夏天","夏日炎炎"){
        public void show()
        {
            System.out.println(2);
        }
    },
    AUTUMN("秋天","秋高气爽")
            {
                public void show()
                {
                    System.out.println(3);
                }
            },
    WINTER("冬天","冰天雪地")
            {
                public void show()
                {
                    System.out.println(4);
                }
            };
    //1、声明Season对象的属性:private final修饰，提供当前枚举类的对象，多个对象之间用“，”隔开，末尾对象“；”结束
    private final String seasonName;
    private final String seasonDesc;

    // 2、私有化类的构造器
    private Season1(String seasonName,String seasonDesc)
    {
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }



    //4、其他诉求：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}


