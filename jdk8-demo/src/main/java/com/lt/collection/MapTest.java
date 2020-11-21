package com.lt.collection;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : litang
 * @date : Create in 2020/6/17
 * @Description
 */
public class MapTest {

    @Test
    public void test01() {
        Map<String, String> map = new HashMap<>();
        Map<String, String> synchronizedMap = Collections.synchronizedMap(map);

        Boolean a = null;
        System.out.println(a?"1":"2");
    }
}
