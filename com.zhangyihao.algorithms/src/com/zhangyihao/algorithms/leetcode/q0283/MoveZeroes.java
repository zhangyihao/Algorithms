package com.zhangyihao.algorithms.leetcode.q0283;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @author zhangyihao
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes t = new MoveZeroes();
        t.moveZeroes(new int[]{1});
        t.moveZeroes(new int[]{0, 0, 0, 0, 0});
        t.moveZeroes(new int[]{0, 1, 0, 3, 12});
        t.moveZeroes(new int[]{1, 0, 2, 0, 3});
        t.moveZeroes(new int[]{1, 5, 2, 3, 4});
    }


    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int i = 0, j = 0, temp = 0;
        while(j < nums.length) {
            if(nums[j] != 0) {
                if(i < j) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }

}
