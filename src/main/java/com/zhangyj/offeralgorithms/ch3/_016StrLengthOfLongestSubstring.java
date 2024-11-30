package com.zhangyj.offeralgorithms.ch3;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题16：不含重复字符的最长子字符串
 * 题目：输入一个字符串，求该字符串中不含重复字符的最长子字符串的长度。
 * 例如，输入字符串"babcca"，其最长的不含重复字符的子字符串是"abc"，长度为3。
 */
public class _016StrLengthOfLongestSubstring {

    public static void main(String[] args) {
        _016StrLengthOfLongestSubstring strLengthOfLongestSubstring = new _016StrLengthOfLongestSubstring();
        System.out.println(strLengthOfLongestSubstring.lengthOfLongestSubstring("babcdbcaf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                maxLength = Math.max(maxLength, set.size());
                set.remove(s.charAt(i));
            }
            set.add(s.charAt(i));
        }
        return maxLength;
    }
}
