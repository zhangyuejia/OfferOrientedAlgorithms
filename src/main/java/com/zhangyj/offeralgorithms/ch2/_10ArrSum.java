package com.zhangyj.offeralgorithms.ch2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：和为k的子数组
 * 输入一个整数数组和一个整数k，请问数组中有多少个数字之和等于k的连续子数组？
 * 例如，输入数组[1，1，1]，k的值为2，有2个连续子数组之和等于2。
 *
 * 解析：双指针解法不适合用于该提，由于数组不保证是正整数，无法保证子数组添加一个新数字得到更大的数组，删去最左边的数字得到更小的数组。
 * 使用累加和法
 *
 */
public class _10ArrSum {

    public int subArraySum(int[] nums, int k) {
        // pre_sum[i]=nums[0]+nums[1]+...+nums[i]
        // sum(l,r) = pre_sum(r) - pre_sum(l - 1) = k
        // pre_sum(r) - k = pre_sum(l - 1)
        // 也就是说如果存在累加和为pre_sum[i] -k, 意味着从某个位置到【当前元素】形成了一个子数组，其和为 k

        // ，key：前缀和 value：出现的次数
        Map<Integer, Integer> sumToCount = new HashMap<>();
        // 刚好当前前缀sum和为k，使得count+1，不然会发生错乱
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            // sum为当前i前缀和
            sum += num;
            // 检查 sum - k 是否存在于哈希表中。如果存在，说明从某个位置到当前元素的子数组和为 k，将其出现次数加到 count 中。
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        _10ArrSum arrSum = new _10ArrSum();
//        int[] arr = {1,1,1,1,-1,3};
        int[] arr = {1, 1, 1, -1, 1};
        System.out.println(arrSum.subArraySum(arr, 1));
    }
}
