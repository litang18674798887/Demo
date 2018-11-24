package com.lt.lambda.test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author : litang
 * @date : Create in 2018/11/24
 */
public class PredicateTest {

    /**
     * 第一个参数是待遍历的集合，第二个参数是Predicate类型的实例
     * @param list
     * @param predicate
     * @return
     */
    public List<Integer> conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
