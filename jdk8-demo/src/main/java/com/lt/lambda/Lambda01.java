package com.lt.lambda;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 函数式接口实例的创建可以有三种方式
 *  1.Lambda表达式
 *  2.方法引用
 *  3.构造方法引用
 *
 * @author : litang
 * @date : Create in 2018/11/24
 */
public class Lambda01 {

    public Lambda01(Integer i){
        System.out.println(i);
    }


    @Test
    public void test01() {
        JFrame jFrame = new JFrame("My JFrame");

        //Button绑定一个监听事件
        JButton jButton = new JButton("My JButton");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Pressed!");
            }
        });
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Lambda表达式的语法是
     * (param1,param2,param3) -> { todo }
     *      1.这里参数的类型程序可以根据上下文进行推断，但是并不是所有的类型都可以推断出来，此时就需要我们显示的声明参数类型，当只有一个参数时小括号可以省略。
     *      2.当todo部分只有一行代码时，外边的大括号可以省略
     *
     * @FunctionalInterface
     *      表示该接口是一个函数式接口。但是如果我们不添加FunctionalInterface注解的话，如果接口中有且只有一个抽象方法时，编译器也会把该接口当做函数式接口看待。
     * 函数式接口实例的创建可以有三种方式
     *      1.Lambda表达式
     *      2.方法引用
     *      3.构造方法引用
     */
    @Test
    public void test02(){
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My JButton");

        jButton.addActionListener(e -> System.out.println("Button Pressed!"));
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * forEach方法，它就是Java8中新增加的默认方法。(详见 Iterable<T>接口 )
     *      首先接收了一个Consumer类型的参数action，进行非空判断，然后遍历当前所有元素交由action的accept方法进行处理
     */
    @Test
    public void test03(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    /**
     * 如果使用lambda表达式来创建一个函数式接口实例，
     *      那这个lambda表达式的入参和返回必须符合这个函数式接口中唯一的抽象方法的定义
     */
    @Test
    public void test04(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //Lambda表达式 接收一个参数 不返回值
        list.forEach(item -> System.out.println(item));
    }

    /**
     * 方法引用的语法是 对象::方法名 (详见 println方法源码)
     */
    @Test
    public void test05(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //这个就是函数式接口实例第二种创建方式：方法引用
        list.forEach(System.out::println);
    }



    /**
     * 构造方法引用的语法是：类名::new
     */
    @Test
    public void test06(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //构造方法引用
        list.forEach(Lambda01::new);
    }

}
