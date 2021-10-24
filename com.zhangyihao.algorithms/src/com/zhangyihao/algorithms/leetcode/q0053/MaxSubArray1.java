package com.zhangyihao.algorithms.leetcode.q0053;

/**
 * 暴力法
 * @author zhangyihao
 */
public class MaxSubArray1 {

    public static void main(String[] args) {
        MaxSubArray1 t = new MaxSubArray1();
        System.out.println(t.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(t.maxSubArray(new int[]{-2, 1}));
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int sum, max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

}
