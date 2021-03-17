package com.zhangyihao.algorithms.leetcode.q0026;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项
 * @author zhangyihao
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        //111.194.234.171
        RemoveDuplicates t = new RemoveDuplicates();
        System.out.println(t.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(t.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(t.removeDuplicates(new int[]{1, 2, 3}));
        System.out.println(t.removeDuplicates(new int[]{1}));
        System.out.println(t.removeDuplicates(new int[]{}));
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int dataIndex = 0, pointIndex = 1;
        while(pointIndex < nums.length) {
            if(nums[dataIndex] != nums[pointIndex]) {
                dataIndex++;
                nums[dataIndex] = nums[pointIndex];
            }
            pointIndex++;
        }
        System.out.println(Arrays.toString(nums));
        return dataIndex + 1;
    }

}
