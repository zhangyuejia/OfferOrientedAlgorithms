package com.zhangyj.offeralgorithms.ch2;

/**
 * 题目：和大于或等于k的最短子数组
 * 输入一个正整数组成的数组和一个正整数k，请问数组中和大于或等于k的连续子数组的最短长度是多少？
 * 如果不存在所有数字之和大于或等于k的子数组，则返回0。
 * 例如，输入数组[5，1，4，3]，k的值为7，和大于或等于7的最短连续子数组是[4，3]，因此输出它的长度2。
 * 思路：双指针
 */
public class _08ArrSub {

    public int minSubArrayLen(int k, int[] nums) {
        // left是子数组中第1个数字的下标
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        // right是子数组中最后一个数字的下标
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= k) {
                minLength = Math.min(minLength, right - left + 1);
                // 删除子数字最左边的元素 剩下的看作为新子数组的组成部分 太牛逼了
                sum -= nums[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        _08ArrSub arrSub = new _08ArrSub();
        int[] arr = {5,1,4,3};
        // 假设数组的长度为n，尽管上述代码中有两个嵌套的循环，该解法的时间复杂度仍然是O（n）。
        // 这是因为在这两个循环中，变量left和right都是只增加不减少，变量right从0增加到n-1，变量left从0最多增加到n-1，因此总的执行次数是O（n）
        System.out.println(arrSub.minSubArrayLen(7, arr));

    }
}
