package com.zhangyihao.algorithms.leetcode.q0031;

import java.util.Arrays;

/**
 * <p>31. 下一个排列</p>
 *
 * <p>实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。</p>
 * <p>如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。</p>
 * <p>必须 原地 修改，只允许使用额外常数空间。</p>
 *
 *  @author zhangyihao
 * @date 2021/11/3
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation t = new NextPermutation();
        t.nextPermutation(new int[] {1, 1});
        t.nextPermutation(new int[] {1, 5, 1});
        t.nextPermutation(new int[] {1, 2, 3});
        t.nextPermutation(new int[] {3, 2, 1});
        //2 6 3 4 5
        t.nextPermutation(new int[] {2, 5, 6, 4, 3});
        //1 2 3 8 6 4 5 7
        t.nextPermutation(new int[] {1, 2, 3, 8, 5, 7, 6, 4});

    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i]) {
                j--;
            }
            this.swap(nums,i, j);
        }
        // 翻转
        this.reverseArray(i + 1,nums.length -1, nums);
        System.out.println(Arrays.toString(nums));
    }

    private void reverseArray(int start, int end, int[] nums) {
        int tmp = 0;
        while(start < end) {
            tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
