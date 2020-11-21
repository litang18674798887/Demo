package com.lt;

import javax.sound.midi.Soundbank;

/**
 * @author : litang
 * @date : Create in 2020/5/28
 * @Description
 */
public class IntegerTest {

    public static void main(String[] args) {

        Integer a = new Integer(1);
        Integer b = new Integer(2);

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        swap(a,b);

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }

    private static void swap (Integer a,Integer b) {
        Integer tmp = a;
        b = a;
        a = tmp;
    }
}
