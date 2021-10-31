package com.zhangyihao.algorithms.leetcode.q0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>题目：三数之和</p>
 * <p>给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。</p>
 * <p>注意：答案中不可以包含重复的三元组。</p>
 * <p>示例：</p>
 * <p>输入：nums = [-1, 0, 1, 2, -1, -4]</p>
 * <p>输出：[[-1. -1. 2], [-1, 0, -1]]</p>
 *
 * <p>提示：1.0 <= nums.length <= 3000</p>
 * <p>2. -105 <= nums[i] <= 105</p>
 *
 * @author zhangyihao
 * @date 2021/1025
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        List<List<Integer>> result = t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        if (result.isEmpty()) {
            System.out.println("[]");
        } else {
            for (List<Integer> data : result) {
               System.out.println(Arrays.toString(data.toArray()));
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int a = 0, len = nums.length; a < len; a++) {
            // 如果第一个元素就大于 0，一定不存在三数之和等于 0 的情况
            if (nums[a] > 0) {
                break;
            }
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int b = a + 1;
            int c = len - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum == 0) {
                    // 找到 a + b + c = 0 的三个数，记录
                    List<Integer> data = new ArrayList<>(3);
                    data.add(nums[a]);
                    data.add(nums[b]);
                    data.add(nums[c]);
                    result.add(data);
                    b++;
                    c--;
                    // 移动指针 b 和 指针 c，并去除重复值
                    while (b < c && nums[b] == nums[b - 1]) {
                        b++;
                    }
                    while (b < c && nums[c] == nums[c + 1]) {
                        c--;
                    }

                } else if (sum > 0) {
                    // 和大于 0 , 说明 b + c 偏大，需要更小的数 ，指针 c 的向前移动
                    c--;
                } else {
                    // 和小于 0，说明 b+ c 偏小，需要更大的数，指针 b 向后移动
                    b++;
                }
            }
        }
        return result;
    }

}
