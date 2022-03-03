package com.zhangyihao.algorithms.leetcode.q0053;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangyihao
 * @date 2022/03/04
 */
public class MergeArray88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;

        // 从后向前，依次将最大值赋值到数组 nums1 中
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[index] = nums1[p1];
                p1--;
            } else {
                nums1[index] = nums2[p2];
                p2--;
            }
            index--;
        }

        // 处理剩余数据
        while (p1 >= 0) {
            nums1[index] = nums1[p1];
            p1--;
            index--;
        }

        while (p2 >= 0) {
            nums1[index] = nums2[p2];
            p2--;
            index--;
        }

    }

    public static void main(String[] args) {
        MergeArray88 t = new MergeArray88();
        t.test1();
        t.test2();
        t.test3();
    }

    public void test1() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        this.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void test2() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        this.merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
    }

    public void test3() {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{2};
        this.merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

}
