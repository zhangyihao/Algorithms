package com.zhangyihao.algorithms.leetcode.q700;

/**
 * 704. 二分查找
 *
 * @author zhangyihao
 * @date 2021/11/24
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch t = new BinarySearch();
        int[] data = new int[]{1, 3, 3, 5, 7, 8, 8, 8, 9};
        System.out.println(t.searchTargetOfRightBound(data, 0));
        System.out.println(t.searchTargetOfRightBound(data, 3));
        System.out.println(t.searchTargetOfRightBound(data, 7));
        System.out.println(t.searchTargetOfRightBound(data, 8));
        System.out.println(t.searchTargetOfRightBound(data, 10));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        int mid;
        // 查找区间范围 [left, right)，注意是左闭右开区间
        // 循环结束条件是 left == right
        // 每次查找范围变化为：[left, mid) 或 【mid + 1, right)
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == right ? -1 : left;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 注意，此时查找区间范围是 [left, right] 闭区间
        // 循环结束条件为：left > right
        // 每次查找变化范围变为：【left, mid - 1] 或【mid + 1, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 找到 target，如果有重复元素，找到第一个 target（左侧边界的 target)
     *
     * @param nums   数组
     * @param target 目标值
     * @return 下标
     */
    public int searchTargetOfLeftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        int mid;
        // 查找区间范围 [left, right)，注意是左闭右开区间
        // 循环结束条件是 left == right
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                // 查找区间变为：[left, mid)
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left >= nums.length || nums[left] != target ? -1 : left;
    }

    /**
     * 找到 target，如果有重复元素，找到最后一个 target（右侧边界的 target)
     *
     * @param nums   数组
     * @param target 目标值
     * @return 下标
     */
    public int searchTargetOfRightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        int mid;
        // 查找区间范围 [left, right)，注意是左闭右开区间
        // 循环结束条件是 left == right
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                // 查找区间变为：[mid + 1, right)
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == 0) {
            return nums[left] == target ? left : -1;
        } else {
            return nums[left - 1] == target ? left - 1 : -1;
        }
    }

}
