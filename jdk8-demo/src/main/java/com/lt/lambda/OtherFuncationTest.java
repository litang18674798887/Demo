package com.lt.lambda;

import com.lt.lambda.test.PredicateTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author : litang
 * @date : Create in 2018/11/24
 */
public class OtherFuncationTest {

    /**
     * Supplier接口，默认抽象方法get不接收参数，有返回值
     */
    @Test
    public void test01(){

        //这里使用构造方法引用的方式创建Supplier实例，通过get直接返回String对象
        Supplier<String> supplier = String::new;
        String s = supplier.get();
        System.out.println(s);
    }

    /**
     * 接收一个参数，返回布尔类型
     */
    @Test
    public void test02(){

        Predicate<String> predicate = s -> s.length() > 5;
        System.out.println(predicate.test("hello"));
    }

    @Test
    public void test03(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest predicateTest = new PredicateTest();

        //integer -> integer > 5 lambda表达式是对Predicate接口的具体实现
        List<Integer> result = predicateTest.conditionFilter(list, integer -> integer > 5);

        //方法引用实例化一个Consumer对象，把结果输出到控制台。
        result.forEach(System.out::println);
    }



}

