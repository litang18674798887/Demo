package com.lt;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author : litang
 * @date : Create in 2020/8/26
 * @Description
 */
public class NumberTest {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] result = test(arr);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public static int[] test(int[] arr) {

        int l = 0; // 左边开始下标
        int r = arr.length - 1; // 右边开始下标

        while (l < r) {

            // 查找奇数
            while (arr[l] % 2 != 0) {
                l++;
            }
            // 查找偶数
            while (arr[r] % 2 != 1) {
                r--;
            }

            if (l < r)
                break;

            // 互换
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;

        }
        return arr;
    }
}
