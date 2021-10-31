package com.zhangyihao.algorithms.leetcode.q0033;


/**
 * 搜索旋转排序数组
 * <p>题目来源：https://leetcode-cn.com/problems/search-in-rotated-sorted-array</p>
 *
 * <p>整数数组 nums 按升序排列，数组中的值 互不相同 。</p>
 * <p>在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。</p>
 * <p>例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。</p>
 * <p>给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。</p>
 *
 * @author zhangyihao
 * @date 2021/10/31
 */
public class Search {

    public static void main(String[] args) {
        Search t = new Search();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        nums = new int[] {6, 7, 0, 1, 2, 4, 5};
        System.out.println(t.search(nums, 4));
        System.out.println(t.search(nums, 5));
        System.out.println(t.search(nums, 6));
        System.out.println(t.search(nums, 7));
        System.out.println(t.search(nums, 0));
        System.out.println(t.search(nums, 1));
        System.out.println(t.search(nums, 2));
        System.out.println(t.search(nums, 3));
        System.out.println(t.search(new int[]{1, 3}, 3));

    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            } else {
                // nums[low] > nums[mid]
                if (nums[low] > target  && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return index;
    }

}
