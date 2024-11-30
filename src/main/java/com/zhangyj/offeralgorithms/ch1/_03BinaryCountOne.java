package com.zhangyj.offeralgorithms.ch1;

import java.util.Arrays;

/**
 * 面试题3：前n个数字二进制中1的个数
 * 输入一个非负数n，请计算0到n之间每个数字的二进制表示中1的个数，并输出一个数组。
 * 例如，输入n为4，由于0、1、2、3、4的二进制表示的1的个数分别为0、1、1、2、1，因此输出数组[0, 1, 1, 2, 1]。
 */
public class _03BinaryCountOne {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            int j = i;
            while (j != 0) {
                result[i]++;
                // j & (j-1) 是一种高效计算整数二进制中 1 的个数的方法，称为 "Brian Kernighan's Algorithm"
                // 每次运算，都能把最右边的1变为0，太牛逼了
                j = j & (j - 1);
            }
        }
        return result;
    }

    public int[] countBits2(int num) {
        // “i&（i-1）”将i的二进制形式中最右边的1变成0，也就是说，
        // 整数i的二进制形式中1的个数比“i&（i-1）”的二进制形式中1的个数多1。
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            result[i] = result[i & (i - 1)] + 1;
        }

        return result;
    }

    /**
     * 从数字奇偶性判断数字1得规律
     */
    public int[] countBits3(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            // 如果正整数i是一个偶数，那么i相当于将“i/2”左移一位的结果，
            // 因此偶数i和“i/2”的二进制形式中1的个数是相同的。
            // 如果i是奇数，那么i相当于将“i/2”左移一位之后再将最右边一位设为1的结果，
            // 因此奇数i的二进制形式中1的个数比“i/2”的1的个数多1。
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }

    public static void main(String[] args) {
        _03BinaryCountOne countOne = new _03BinaryCountOne();
        // 时间复杂度是O（nk） k为1的个数
        System.out.println(Arrays.toString(countOne.countBits(9)));
        // 时间复杂度是O（n）
        System.out.println(Arrays.toString(countOne.countBits2(9)));
        // 时间复杂度是O（n）
        System.out.println(Arrays.toString(countOne.countBits3(9)));
    }
}
