package com.zhangyihao.algorithms.leetcode.q0003;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * @author zhangyihao
 * @date 2021/11/8
 */
public class LengthOfStrBySet {

    public static void main(String[] args) {
        LengthOfStrBySet t = new LengthOfStrBySet();
        System.out.println(t.lengthOfLongestSubstring(""));
        System.out.println(t.lengthOfLongestSubstring("a"));
        System.out.println(t.lengthOfLongestSubstring("bbbbb"));
        System.out.println(t.lengthOfLongestSubstring("pwwkewa"));
        System.out.println(t.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int maxLen = 0, end = 0;
        int length = s.length();
        Set<Character> charSet = new HashSet<>();
        for(int start = 0; start < length; start++) {
            if (start > 0) {
                charSet.remove(s.charAt(start - 1));
            }
            while(end < length && !charSet.contains(s.charAt(end))) {
                charSet.add(s.charAt(end));
                end++;
            }
            int len  = end - start;
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }

    public int aaa(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
