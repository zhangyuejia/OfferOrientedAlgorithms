package com.zhangyj.offeralgorithms.ch2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：排序数组中的两个数字之和
 * 输入一个递增排序的数组和一个值k，请问如何在数组中找出两个和为k的数字并返回它们的下标？假设数组中存在且只存在
 * 一对符合条件的数字，同时一个数字不能使用两次。例如，输入数组[1，2，4，6，10]，k的值为8，数组中的数字2与6的和为8，它们
 * 的下标分别为1与3。
 */
public class _06ArrTwoSum {

    /**
     * 方向相反的双指针经常用来求排序数组中的两个数字之和。一个指针P1指向数组的第1个数字，另一个指针P2指向数组的最后一个数
     * 字，然后比较两个指针指向的数字之和及一个目标值。如果两个指针指向的数字之和大于目标值，则向左移动指针P2；如果两个指针指向的
     * 数字之和小于目标值，则向右移动指针P1。此时两个指针的移动方向是相反的。
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[] {i, j};
    }

    public static void main(String[] args) {
        _06ArrTwoSum twoSum = new _06ArrTwoSum();
        int target = 8;
        int[] arr = {1,2,5,6,9,10};
        System.out.println(Arrays.toString(twoSum.twoSum(arr, target)));
        System.out.println(Arrays.toString(twoSum.twoSum2(arr, target)));
    }

    private int[] twoSum2(int[] numbers, int target) {
        // 使用哈希，以空间换时间，时间复杂度和空间复杂度都为0（n）
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{i, map.get(target - numbers[i])};
            }
        }
        return new int[]{0, 0};
    }
}
