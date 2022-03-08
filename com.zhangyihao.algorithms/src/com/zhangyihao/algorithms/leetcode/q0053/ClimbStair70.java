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

    /**
     * 变种：逢 7 的楼梯不能上，即第 7、14、21... 阶台阶不能上
     * @param n 台阶数
     */
    public void climbStairs2(int n) {
        // 思路： n -1 或 n - 2 % 7 == 0 时，dp[n-1] 或 dp[n - 2] 等于 0
    }

    /**
     * 变种：输出所有路径
     * @param n 台阶数
     */
    public void climbStair3(int n) {
        // 思路：递归构造以第 n 阶台阶为根节点的二叉树，反向输出二叉树的每条路径
    }

    public static void main(String[] args) {
        ClimbStair70 t = new ClimbStair70();
        for (int i = 1; i<= 10; i++) {
            System.out.println(i + ": " + t.climbStairs(i));
        }
    }
}
