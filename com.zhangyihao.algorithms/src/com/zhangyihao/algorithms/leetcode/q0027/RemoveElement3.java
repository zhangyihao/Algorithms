package com.zhangyihao.algorithms.leetcode.q0027;

/**
 * @author zhangyihao
 */
public class RemoveElement3 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                while( i <= j && nums[j] == val) {
                    j--;
                }
                if(j <= i) {
                    break;
                }
                nums[i] = nums[j];
                j--;
            }
            i++;
        }
        return i;
    }
}
