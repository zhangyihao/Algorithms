package com.zhangyihao.algorithms.leetcode.q0053;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author zhangyihao
 * @date 2022/3/8
 */
public class ClimbStair70 {
ª
    public int climbStairs(int n) {
        // 状态：n 台阶数
        // 选择：1阶、2 阶
        // dp 方程：dp[n] = dp[n - 1] + dp[n - 2]
        // base case: dp[1] = 1, dp[2] = 2
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int dpn1 = 1, dpn2 = 2;
        int dpn = 1;
        for (int i = 3; i <= n; i++) {
            dpn = dpn1 + dpn2;
            dpn1 = dpn2;
            dpn2 = dpn;
        }
        return dpn;
    }

    public static void main(String[] args) {
        ClimbStair70 t = new ClimbStair70();
        for (int i = 1; i<= 10; i++) {
            System.out.println(i + ": " + t.climbStairs(i));
        }
    }
}
