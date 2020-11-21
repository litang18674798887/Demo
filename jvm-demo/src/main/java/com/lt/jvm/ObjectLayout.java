package com.lt.jvm;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 *
 * 对象布局
 *
 * @author : litang
 * @date : Create in 2020/4/25
 * @Description
 */
public class ObjectLayout {


    /**
     * 查看新建一个对象有多少个字节
     */
    @Test
    public void test01 (){
        Object o = new Object();
        // 16 个字节
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    @Test
    public void test02 (){
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            num = 0;
        }
    }
}
