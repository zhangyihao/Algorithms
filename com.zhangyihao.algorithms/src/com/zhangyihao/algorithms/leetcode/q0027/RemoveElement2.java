package com.zhangyihao.algorithms.leetcode.q0027;

/**
 * 前后指针，减少赋值的次数
 * @author zhangyihao
 */
public class RemoveElement2 {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            if(nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }

}
