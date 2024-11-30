package com.zhangyj.offeralgorithms.ch1;

/**
 * 面试题1：整数除法
 * 输入两个int型整数，求它们除法的商，要求不得使用乘号'*'、除号'/'以及求余符号'%'。
 * 当发生溢出时返回最大的整数值。假设除数不为0。例如，输入15和2，输出15/2的结果，即7。
 *
 * 思路：使用减法实现除法
 */
public class _01IntegerDivide {

    public int divide(int dividend, int divisor) {
        // 0x80000000为最小的int整数，即-2^31
        if (dividend == 0x80000000 && divisor == -1){
            return Integer.MAX_VALUE;
        }

        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }

        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }

    private int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            // 效率提升点，value为除数*2^n
            int value = divisor;
            // 商
            int quotient = 1;
            // 0xc0000000为最小整数的一般 即-2^30
            while (value >= 0xc0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }

        return result;
    }

    public static void main(String[] args) {
        _01IntegerDivide divider = new _01IntegerDivide();
        // 时间复杂度为O（logn）
        System.out.println(divider.divide(-10, 3));
    }
}
