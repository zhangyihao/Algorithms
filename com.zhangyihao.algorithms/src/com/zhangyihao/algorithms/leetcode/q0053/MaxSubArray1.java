package com.zhangyihao.algorithms.leetcode.q0053;

/**
 * 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author zhangyihao
 */
public class MaxSubArray1 {

    public static void main(String[] args) {
        MaxSubArray1 t = new MaxSubArray1();
        System.out.println(t.maxSubArray3WithArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(t.maxSubArray3WithArray(new int[]{-2, 1}));
        System.out.println(t.maxSubArray3WithArray(new int[]{-2}));
    }

    /**
     * 暴力法
     * @param nums 数组
     * @return 最大和
     */
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

    /**
     * 动态规划
     * @param nums 数组
     * @return 最大和
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        // 状态：n
        // 选择：相加、不加
        // dp: max[n] = max(nums[n - 1], max[n - 1] + nums[n])
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int n = 1; n < len; n++) {
            dp[n] = Math.max(nums[n], dp[n - 1] + nums[n]);
            if (max < dp[n]) {
                max = dp[n];
            }
        }
        return max;
    }

    /**
     * 动态规划，对 maxSubArray2 的优化，减少内存
     * @param nums 数组
     * @return 最大和
     */
    public int maxSubArray3(int[] nums) {
        int len = nums.length;
        // 状态：n
        // 选择：相加、不加
        // dp: max[n] = max(nums[n - 1], max[n - 1] + nums[n])
        int prevMax = nums[0];
        int max = nums[0];
        for (int n = 1; n < len; n++) {
            prevMax = Math.max(nums[n], prevMax + nums[n]);
            max = Math.max(prevMax, max);
        }
        return max;
    }

    public int maxSubArray4(int[] nums) {
        int prevMax = 0;
        int max = nums[0];
        for (int num : nums) {
            prevMax = Math.max(num, prevMax + num);
            max = Math.max(prevMax, max);
        }
        return max;
    }

    public int maxSubArray3WithArray(int[] nums) {
        int len = nums.length;
        // 状态：n
        // 选择：相加、不加
        // dp: max[n] = max(nums[n - 1], max[n - 1] + nums[n])
        int prevMax = nums[0];
        int max = nums[0];
        int result;
        int startIndex = 0;
        int endIndex = 0;
        for (int n = 1; n < len; n++) {
            result = prevMax + nums[n];
            prevMax = Math.max(result, nums[n]);
            // 如果 result 最大，即加入当前值，最大值变化后，
            if (result > max && result > nums[n]) {
                endIndex++;
                max = result;
            } else if (nums[n] > max && nums[n] > result) {
                startIndex = n;
                endIndex = n;
                max = nums[n];
            }
//            else if (max > nums[n] && max > result) {
//                // do nothing
//            }
        }
//        int[] subArray = new int[endIndex - startIndex + 1];
//        for (int i = startIndex; i <= endIndex; i++) {
//            subArray[i - startIndex] = nums[i];
//        }
        System.out.println("max sub array range: " + startIndex + "," + endIndex);
        return max;
    }

}
