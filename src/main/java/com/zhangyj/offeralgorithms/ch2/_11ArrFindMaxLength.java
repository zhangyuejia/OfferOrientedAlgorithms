package com.zhangyj.offeralgorithms.ch2;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：0和1个数相同的子数组
 * 输入一个只包含0和1的数组，请问如何求0和1的个数相同的最长连续子数组的长度？例如，在数组[0，1，0]中有两个子数
 * 组包含相同个数的0和1，分别是[0，1]和[1，0]，它们的长度都是2，因此输出2。
 *
 * 思路：如果将数组里面的0看成是1，题目就变成求最长连续子数组和为0的长度，可以使用累加和方法求解
 *
 */
public class _11ArrFindMaxLength {

    public int findMaxLength(int[] nums) {
        // key:累加和 value:当前的下标
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; ++i) {
            // 将0转化为-1
            sum += nums[i] == 0 ? -1 : 1;
            // 包含则证明存在某个位置到i的子数组和为0
            if (sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            } else {
                // 只保存第一个，也就是最小的下标，牛逼
                sumToIndex.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0};
        _11ArrFindMaxLength findMaxLength = new _11ArrFindMaxLength();
        System.out.println(findMaxLength.findMaxLength(nums));
    }
}
