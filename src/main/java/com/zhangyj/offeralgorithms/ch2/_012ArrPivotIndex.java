package com.zhangyj.offeralgorithms.ch2;

/**
 * 题目：左右两边子数组的和相等
 * 输入一个整数数组，如果一个数字左边的子数组数字之和等于右边的子数组数字之和，请返回该数字的下标。如果存在多个这样的数字，则返回最左边一个的下标。
 * 如果不存在这样的数字，则返回-1。例如在数组[1, 7, 3, 6, 2, 9]中，下标为3的数字（值为6）左边三个数字1、7、3和右边两个数字2和9的和相等，都是11，因此正确的输出值是3。
 */
public class _012ArrPivotIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 2, 9};
        _012ArrPivotIndex pivotIndex = new _012ArrPivotIndex();
        System.out.println(pivotIndex.pivotIndex(nums));
    }
// 以下是自己写的版本
//    private int pivotIndex(int[] nums) {
//        int allSum = 0;
//        for (int num : nums) {
//            allSum += num;
//        }
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (allSum - sum *2 == nums[i]) {
//                return i;
//            }
//            sum += nums[i];
//        }
//        return -1;
//    }

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum - nums[i] == total - sum) {
                return i;
            }
        }

        return -1;
    }
}
