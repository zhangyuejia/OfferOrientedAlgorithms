package com.zhangyj.offeralgorithms.ch1;

/**
 * 面试题5：单词长度的最大乘积
 * 输入一个字符串数组words，请计算当两个字符串words[i]和words[j]不包含相同字符时它们长度的乘积的最大值。
 * 如果没有不包含相同字符的一对字符串，那么返回0。假设字符串中只包含英语的小写字母。
 * 例如，输入的字符串数组words为["abcw", "foo", "bar", "fxyz","abcdef"]，
 * 数组中的字符串"bar"与"foo"没有相同的字符，它们长度的乘积为9。"abcw"与" fxyz "也没有相同的字符，
 * 它们长度的乘积是16，这是不含相同字符的一对字符串的长度乘积的最大值。
 *
 */
public class _05BinaryMaxWordLengthMultiply {

    /**
     * 使用哈希表
     */
    public int maxProduct(String[] words) {
        // 每个单词哈希表，小写字母出现时，对应下标标识为true
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for(char c: words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    // 一旦出现相同字母，跳过
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                // 无重复字母，计算较大值
                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"def", "fff", "t", "ppp", "rtrt", "kkl", "ooooooo"};
        _05BinaryMaxWordLengthMultiply maxWordLengthMultiply = new _05BinaryMaxWordLengthMultiply();
        System.out.println(maxWordLengthMultiply.maxProduct(words));
        // 如果数组words的长度为n，平均每个字符串的长度为k，那么这种解法的时间复杂度是O（nk+n^2），空间复杂度是O（n）。
        System.out.println(maxWordLengthMultiply.maxProduct2(words));
    }

    private int maxProduct2(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i] = flags[i] | (1 << (c - 'a'));
            }
        }

        int result = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // 使用数字存储所有数位的值，进行&运算判断是否存在同位的字母
                if ((flags[i] & flags[j]) != 0) {
                    break;
                }
                result = Math.max(result, words[i].length() * words[j].length());
            }
        }
        return result;
    }
}
