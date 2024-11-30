package com.zhangyj.offeralgorithms.ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题15：字符串中的所有变位词
 * 题目：输入字符串s1和s2，如何找出字符串s2的所有变位词在字符串s1中的起始下标？假设两个字符串中只包含英文小写字母。
 * 例如，字符串s1为"cbadabacg"，字符串s2为"abc"，字符串s2的两个变位词"cba"和"bac"是字符串s1中的子字符串，
 * 输出它们在字符串s1中的起始下标0和5
 *
 * 思路：同14题，双指针 + 哈希数组
 */
public class _015StrFindAnagrams {

    public static void main(String[] args) {
        _015StrFindAnagrams strFindAnagrams = new _015StrFindAnagrams();
        System.out.println(strFindAnagrams.findAnagrams("cbadabacg", "abc"));
    }

    public List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> indices = new ArrayList<>();
        int[] counts = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a'] ++;
            counts[s1.charAt(i) - 'a'] --;
        }
        if (areAllZero(counts)) {
            indices.add(0);
        }
        for (int i = s2.length(); i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a'] --;
            counts[s1.charAt(i - s2.length()) - 'a' ] ++;
            if (areAllZero(counts)) {
                // 上面删去的下标是i - s2.length()，所以子串的起始下标是i - s2.length() + 1
                indices.add(i - s2.length() + 1);
            }
        }

        return indices;
    }

    public boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
