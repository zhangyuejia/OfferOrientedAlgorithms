package com.zhangyj.offeralgorithms.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：乘积小于k的子数组
 * 输入一个由正整数组成的数组和一个正整数k，请问数组中有多少个数字乘积小于k的连续子数组？
 * 例如，输入数组[10，5，2，6]，k的值为100，有8个子数组的所有数字的乘积小于100，
 * 它们分别是[10]、[5]、[2]、[6]、[10，5]、[5，2]、[2，6]和[5，2，6]。
 */
public class _09ArrMultiplyLessThen {

    public static void main(String[] args) {
        _09ArrMultiplyLessThen lessThen = new _09ArrMultiplyLessThen();
        int[] arr = {10,5,2,6};
        // 时间复杂度也是O（n）🍪
        System.out.println(lessThen.numSubArrayProductLessThanK(arr, 100));
        System.out.println(lessThen.arrMultiplyLessThen(arr, 100));
    }

    public int numSubArrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; ++right) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            // 如果子数组乘积达到条件，证明其满足条件的子数组个数为right-left+1（因为为正整数）
            count += right >= left ? right - left + 1 : 0;
        }

        return count;
    }

    private int arrMultiplyLessThen(int[] arr, int k) {
        // 自己写的，思路和作者相反，for循环为数组最左边指针
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int right = i;
            while (num < k) {
                result ++;
                right++;
                if(right < arr.length) {
                    num = num*arr[right];
                }else {
                    break;
                }
            }
        }
        
        return result;
    }
}
