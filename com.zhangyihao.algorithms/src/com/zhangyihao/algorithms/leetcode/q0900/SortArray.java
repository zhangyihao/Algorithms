package com.zhangyihao.algorithms.leetcode.q0900;

import java.util.Arrays;
import java.util.Random;

/**
 * 912. 排序数组ª
 */
public class SortArray {

    public static void main(String[] args) {
        SortArray t = new SortArray();
//        t.sortArray(new int[]{5});
//        t.sortArray(new int[]{5, 3});
//        t.sortArray(new int[]{1, 2, 3});
//        t.sortArray(new int[]{5, 2, 3, 1});
//        t.sortArray(new int[]{5, 2, 3, 9});
//        t.sortArray(new int[]{4, 3, 2, 4, 3, 2, 1});
//        t.sortArray(new int[]{5, 1, 1, 2, 0, 0, 3, 1});


        int size = 10000;
        int[] nums1 = new int[size];
        int[] nums2 = new int[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int data = random.nextInt(size);
            nums1[i] = data;
            nums2[i] = data;
        }

//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums2));

        t.testSortCost(nums1);
        t.testSortRandomCost(nums2);
    }

    public void testSortCost(int[] nums) {
        long begin = System.currentTimeMillis();
        this.sort(nums, 0, nums.length - 1);
        long cost = System.currentTimeMillis() - begin;
        System.out.println("cost=" + cost);
    }

    public void testSortRandomCost(int[] nums) {
        long begin = System.currentTimeMillis();
        this.randomSort(nums, 0, nums.length - 1);
        long cost = System.currentTimeMillis() - begin;
        System.out.println("random cost=" + cost);
    }

    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            this.sort(nums, 0, nums.length - 1);
        }
        return nums;
    }

    /**
     * 标准快排，以待排序数组总的第一个元素为基准元素
     * @param nums 数组
     * @param begin 开始索引
     * @param end 结束索引
     */
    private void sort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int point1 = begin;
        int point2 = end;
        int base = nums[begin];
        while (point1 < point2) {
            // 从右边开始，找到第一个比基准值小的数
            while (point1 < point2 && base <= nums[point2]) {
                point2--;
            }
            // 如果指针相遇了，说明右边的比左边的都大，结束循环
            if (point1 == point2) {
                break;
            }
            nums[point1] = nums[point2];
            point1++;

            while(point1 < point2 && nums[point1] < base) {
                point1++;
            }

            if (point1 == point2) {
                break;
            }
            nums[point2] = nums[point1];
            point2--;
        }
        nums[point1] = base;
        this.sort(nums, begin, point1 - 1);
        this.sort(nums, point1 + 1, end);
    }

    /**
     * 随机选择基准值进行排序
     * @param nums 数组
     * @param begin 起始索引
     * @param end 结束索引
     */
    private void randomSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
//        int baseIndex = begin + (end - begin) / 2;
        int baseIndex = new Random().nextInt(end - begin + 1) + begin;
        int base = nums[baseIndex];
        nums[baseIndex] = nums[begin];

        int point1 = begin;
        int point2 = end;
        while (point1 < point2) {
            // 从右边开始，找到第一个比基准值小的数
            while (point1 < point2 && base <= nums[point2]) {
                point2--;
            }
            // 如果指针相遇了，说明右边的比左边的都大，结束循环
            if (point1 == point2) {
                break;
            }
            nums[point1] = nums[point2];
            point1++;

            while(point1 < point2 && nums[point1] < base) {
                point1++;
            }

            if (point1 == point2) {
                break;
            }
            nums[point2] = nums[point1];
            point2--;
        }
        nums[point1] = base;
        this.randomSort(nums, begin, point1 - 1);
        this.randomSort(nums, point1 + 1, end);
    }

}
