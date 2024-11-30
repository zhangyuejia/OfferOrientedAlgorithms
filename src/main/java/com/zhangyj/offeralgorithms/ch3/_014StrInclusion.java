package com.zhangyj.offeralgorithms.ch3;

/**
 * 面试题14：字符串中的变位词
 * 题目：输入字符串s1和s2，如何判断字符串s2中是否包含字符串s1的某个变位词？
 * 如果字符串s2中包含字符串s1的某个变位词，则字符串s1至少有一个变位词是字符串s2的子字符串。
 * 假设两个字符串中只包含英文小写字母。例如，字符串s1为"ac"，字符串s2为"dgcaf"，
 * 由于字符串s2中包含字符串s1的变位词"ca"，因此输出为true。如果字符串s1为"ab"，字符串s2为"dgcaf"，则输出为false。
 *
 * 思路：
 * 变位词：单词字母出现的次数一致，只是顺序不同
 * 双指针+哈希表，变位次特性：字母出现次数一致
 * 1.统计s1字母出现的次数
 * 2.双指针移动时，对右边新加入的字母-1，左边删去的字母+1
 */
public class _014StrInclusion {

    public static void main(String[] args) {
        _014StrInclusion strInclusion = new _014StrInclusion();
        System.out.println(strInclusion.checkInclusion("ad", "cdgaf"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        // 明确写了是小写字母，创建一个长度26的数组
        // 双指针移动时，对右边新加入的字母-1，左边删去的字母+1，牛逼，这样侧面也保证了顺序，也不用复制多个数组，只用一个数组就可以一直用
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            // 统计的同时进行计算，牛逼
            counts[s2.charAt(i) - 'a']--;
        }
        if (areAllZero(counts)) {
            return true;
        }
        // 注意到双指针的长度一直是s1.length() 牛逼
        for (int i = s1.length(); i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if (areAllZero(counts)) {
                return true;
            }
        }
        return false;
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

