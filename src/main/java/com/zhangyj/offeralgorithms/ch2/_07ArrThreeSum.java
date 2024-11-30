package com.zhangyj.offeralgorithms.ch2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：数组中和为0的3个数字
 * 输入一个数组，如何找出数组中所有和为0的3个数字的三元组？
 * 需要注意的是，返回值中不得包含重复的三元组。例如，在数组[-1，0，1，2，-1，-4]中有两个三元组的和为0，
 * 它们分别是[-1，0，1]和[-1，-1，2]。
 * 思路：排序后双指针
 */
public class _07ArrThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);

            int i = 0;
            while(i < nums.length - 2) {
                twoSum(nums, i, result);

                int temp = nums[i];
                // 跳过重复的数字
                while(i < nums.length && nums[i] == temp) {
                    ++i;
                }
            }
        }

        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                int temp = nums[j];
                // 跳过重复的数字
                while (nums[j] == temp && j < k) {
                    ++j;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                ++j;
            } else {
                --k;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,4,7,-8,-4,1,3,5, -7,2,-9,10};
        _07ArrThreeSum threeSum = new _07ArrThreeSum();
        System.out.println(threeSum.threeSum(arr));
    }
}
