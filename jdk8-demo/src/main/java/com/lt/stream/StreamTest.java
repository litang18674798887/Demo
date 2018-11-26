package com.lt.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author : litang
 * @date : Create in 2018/11/24
 */
public class StreamTest {

    @Test
    public void test01(){
        List<String> list = Arrays.asList("hello","world","helloworld");
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length() > 5){
                System.out.println(list.get(i).toUpperCase());
            }
        }
    }

    /**
     *  stream方法先构造了一个该集合的Stream对象
     *
     *  filter方法取出长度大于5的字符串
     *       Stream<T> filter(Predicate<? super T> predicate);
     *       filter方法，接收一个Predicate函数式接口类型作为参数，并返回一个Stream对象
     *          从上一篇我们知道可以由一个接收一个参数返回布尔类型的lambda表达式来创建Predicate函数式接口实例
     *          所以看到filter接收的参数是s -> s.length() > 5
     *
     *  map方法将所有字符串转大写
     *       <R> Stream<R> map(Function<? super T, ? extends R> mapper);
     *       map方法，接收Function函数式接口类型，接收一个参数，有返回值s -> s.toUpperCase() 正是做了这件事情
     *
     *  forEach输出到控制台
     *      void forEach(Consumer<? super T> action);
     *      forEach方法，接收Consumer函数式接口类型，接收一个参数，不返回值 这里使用方法引用的其中一种形式
     */
    @Test
    public void test02(){
        List<String> list = Arrays.asList("hello","world","helloworld");
        list.stream().filter(s -> s.length() > 5).map(s -> s.toUpperCase()).forEach(System.out::println);
    }

    /**
     *
     * 实际上map方法中可以使用另一种方法引用的形式来处理，类方法引用。语法：类名::方法名
     *
     * System.out::println这种属于对象方法引用，类方法引用的应用也是很广泛的。
     * 只是理解起来需要花费些时间，map方法接收一个Function函数式接口的实现，那就肯定需要一个输入并且有一个输出，但是我们看下toUpperCase方法的定义
     */
    @Test
    public void test03(){
        List<String> list = Arrays.asList("hello","world","helloworld");
        list.stream().filter(s -> s.length() > 5).map(String::toUpperCase).forEach(System.out::println);
    }



}
