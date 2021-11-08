package com.zhangyihao.algorithms.leetcode.q0003;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * @author zhangyihao
 * @date 2021/11/8
 */
public class LengthOfStr {

    public static void main(String[] args) {
        LengthOfStr t = new LengthOfStr();
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
        int maxLen = 1, start = 0, end;
        char[] strArray = s.toCharArray();
        while(start < strArray.length - 1) {
            end = start + 1;
            while(end < strArray.length && !this.duplicateChart(strArray[end], start, end, strArray)) {
                end++;
            }
            int len  = end - start;
            if (len > maxLen) {
                maxLen = len;
            }
            start++;
        }
        return maxLen;
    }

    private boolean duplicateChart(char ch, int start, int end, char[] array) {
        for (int i = start; i < end; i++) {
            if (ch == array[i]) {
                return true;
            }
        }
        return false;
    }

}
