package com.zhangyj.offeralgorithms.ch1;

/**
 * 面试题4：只出现一次的数字
 * 题目：输入一个整数数组，数组中只有一个数字出现了一次，而其他数字都出现了3次。请找出那个只出现一次的数字。例如，如
 * 果输入的数组为[0，1，0，1，0，1，100]，则只出现一次的数字是 * 100

 * 解析：
 * 一个整数是由32个0或1组成的。我们可以将数组中所有数字的同一位置的数位相加。如果将出现3次的数字单独拿出来，那么这些出现
 * 了3次的数字的任意第i个数位之和都能被3整除。因此，如果数组中所有数字的第i个数位相加之和能被3整除，那么只出现一次的数字的第i
 * 个数位一定是0；如果数组中所有数字的第i个数位相加之和被3除余1，那么只出现一次的数字的第i个数位一定是1。
 */
public class _04BinaryFindAppearOnce {

    public int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }

        return result;
    }

    public static void main(String[] args) {
        _04BinaryFindAppearOnce appearOnce = new _04BinaryFindAppearOnce();
        // 简单版本：数组中只有一个数字出现了一次，其余数字出现2次，
        // 思路：数组所有异或，结果就是出现1次的数字，因为数字自身进行异或运算后值为0
        int[] numbs1 = {1,3,4,1,3,9,4};
        System.out.println("只出现1次的数字：" + appearOnce.singleNumberInTwice(numbs1));

        int[] numbs = {1,3,4,1,3,4,9,1,3,4};
        System.out.println("只出现1次的数字：" + appearOnce.singleNumber(numbs));

        // 以上解决方法可以解决以下类型
        // 题目：输入一个整数数组，数组中只有一个数字出现m次，其他数字都出现n次。
        // 请找出那个唯一出现m次的数字。假设m不能被n整除。
    }

    private int singleNumberInTwice( int[] numbs) {
        int result = 0;
        for (int i = 0; i < numbs.length; i++) {
            result = result ^numbs[i];
        }
        return result;
    }
}
