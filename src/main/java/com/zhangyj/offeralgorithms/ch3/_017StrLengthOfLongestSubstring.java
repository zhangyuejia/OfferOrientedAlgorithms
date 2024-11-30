package com.zhangyj.offeralgorithms.ch3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题16：不含重复字符的最长子字符串
 * 题目: 输入一个字符串，求该字符串中不含重复字符的最长连续子字符串的长度。
 * 例如，输入字符串"babcca"，它最长的不含重复字符串的子字符串是"abc"，长度为3。
 */
public class _017StrLengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        return 0;
    }

    public static void main(String[] args) {
        _017StrLengthOfLongestSubstring strLengthOfLongestSubstring = new _017StrLengthOfLongestSubstring();
        System.out.println(strLengthOfLongestSubstring.lengthOfLongestSubstring(""));
    }
}
