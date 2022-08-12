package com.atguigu.java1;

import org.junit.Test;

/**1.理解注解
 * 2.Annotation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查（JDK内置的三个基本注解）
 * 示例三：配置文件功能
 *
 *
 * jdk 提供的4种元注解
 * 元注解：对现有的注解进行解释说明的注解
 * Retention:指定所修饰的Annotation的声明周期：SOURCE\CLASS(默认行为)\RUNTIME
 * 只有声明为RUNTIME声明周期的注解，才能通过反射获取。
 * @author xiewei
 * @create 2022-07-07 21:31
 */
public class AnnotationTest {
    @Test
    public void test()
    {
            @MyAnnotation({"未定义的变量","需要定义变量"})
                    int a;
    }
}
