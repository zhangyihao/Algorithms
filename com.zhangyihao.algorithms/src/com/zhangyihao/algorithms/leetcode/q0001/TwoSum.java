package com.zhangyihao.algorithms.leetcode.q0001;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 *
 *
 * @author zhangyihao1
 * @Date 2019/7/10
 *
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int num;
        for(int i=0, len = nums.length; i<len; i++) {
            num = nums[i];
            if(num >= target) {
                continue;
            }
            for(int j=i+1; j<len; j++) {
                if(num + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 时间复杂度为 O(n)
     * @param nums 数组
     * @param target 结果
     * @return 结果
     */
    private int[] towSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for(int i=0; i<len; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
