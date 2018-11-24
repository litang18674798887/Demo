package com.lt.lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * Function 函数
 *      R apply(T t);  该函数式接口唯一的抽象方法apply接收一个参数，有返回值
 *
 * @author : litang
 * @date : Create in 2018/11/24
 */
public class FunctionTest {

    @Test
    public void test01 (){
        FunctionTest functionTest = new FunctionTest();
        int i2 = functionTest.add2(2);
        System.out.println(i2);
        int i3 = functionTest.add3(2);
        System.out.println(i3);
        int i4 = functionTest.add4(2);
        System.out.println(i4);
    }

    /**
     * 这样我们可以将方法定义的更抽象，代码重用性也就越高，每次将要计算的数据和计算逻辑一起作为参数传递给compute方法就可以。
     */
    @Test
    public void test02 (){

        //注：因为表达式只有一行语句 num -> num + 2 可以省略了return 关键字 如果为了更加直观可以写成 num -> return num + 2
        int result2 = FunctionTest.compute(5, num -> num + 2);
        int result3 = FunctionTest.compute(5, num -> num + 2);
        int result4 = FunctionTest.compute(5, num -> num + 2);
        int results = FunctionTest.compute(5, num -> num * num);

        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(results);
    }

    //逻辑提前定义好
    public int add2(int i){
        return i + 2;
    }

    //逻辑提前定义好
    public int add3(int i){
        return i + 3;
    }

    //逻辑提前定义好
    public int add4(int i){
        return i + 4;
    }

    //调用时传入逻辑
    public static int compute(int i, Function<Integer, Integer> function){
        Integer result = function.apply(i);
        return result;
    }

}
