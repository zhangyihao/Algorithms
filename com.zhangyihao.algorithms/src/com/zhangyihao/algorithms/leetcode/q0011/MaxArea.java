package com.zhangyihao.algorithms.leetcode.q0011;

/**
 * 盛水最多的容器 <br/>
 * <p>给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。</p>
 * <p>在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。</p>
 * <p>找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水</p>
 * <p>链接：https://leetcode-cn.com/problems/container-with-most-water</p>
 *
 * @author zhangyihao
 * @date 2021/10/24
 */
public class MaxArea {

    public static void main(String[] args) {
        MaxArea t = new MaxArea();
        System.out.println(t.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int area = 0;
        while (i < j) {
            // S = (j - i) * min(height[i], height[j])
            if (height[i] < height[j]) {
                area = (j - i) * height[i];
                i++;
            } else {
                area = (j - i) * height[j];
                j--;
            }
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

}
