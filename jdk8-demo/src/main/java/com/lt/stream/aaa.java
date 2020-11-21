package com.lt.stream;

import javax.sound.midi.Soundbank;

/**
 * @author : litang
 * @date : Create in 2020/8/26
 * @Description
 */
public class aaa {

    static boolean foo(char c) {
        System.out.println(c);
        return true;
    }


    public static void main(String[] args) {
        int i = 0;
        for(foo('A');(foo('B') && i < 2);foo('C')) {
            i++;
            foo('D');
            System.out.println(11111);
        }
    }
}
