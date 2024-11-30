package com.zhangyj.offeralgorithms.ch1;

/**
 * 面试题2：二进制加法
 * 输入两个表示二进制的字符串，请计算它们的和，并以二进制字符串的形式输出。
 * 例如输入的二进制字符串分别是"11"和"10"，则输出"101"
 *
 * 思路：解析字符串，逢二进一
 */
public class _02BinaryAdd {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }

        if (carry == 1) {
            result.append(1);
        }
        // 由于是低位开始，所以需要翻转
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        _02BinaryAdd addBinary = new _02BinaryAdd();
        System.out.println(addBinary.addBinary("001", "0100"));
    }
}
