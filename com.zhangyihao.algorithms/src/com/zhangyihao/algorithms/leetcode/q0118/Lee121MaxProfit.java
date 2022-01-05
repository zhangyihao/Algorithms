package com.zhangyihao.algorithms.leetcode.q0118;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author zhangyihao
 * @date 2022/01/05
 */
public class Lee121MaxProfit {

    public static void main(String[] args) {
        Lee121MaxProfit t = new Lee121MaxProfit();
        System.out.println(t.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(t.maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }

    /**
     * 动态规划解法-1
     * @param prices 股票价格
     * @return 最大利润
     */
    public int maxProfit1(int[] prices) {
        // 状态：天数、持有状态（0、1）
        // 选择：买入、卖出、保持不变，约束条件：买入后才能卖出。
        // 状态转移方程：n 表示天数、0/1 表示持有状态
        // dp[n][0] = max(dp[n-1][0], dp[n-1][1] + prices[n]) = max(昨天未持有的利润， 今天卖出的利润)
        // dp[n][1] = max(dp[n-1][1], -prices[n]) = max(昨天持有的利润， 今天买入的利润)
        // base case: dp[-1][0] = 0、dp[-1][1] = -无穷大 => dp[0][0] = 0、dp[0][1] = -price[0]

        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 动态规划解法-2， 在解法 1 的基础上，使用"备忘录"方式，优化空间复杂度
     * @param prices 股票价格
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        int dpLast0 = 0;
        int dpLast1 = Integer.MIN_VALUE;

        for (int price : prices) {
            dpLast0 = Math.max(dpLast0, dpLast1 + price);
            dpLast1 = Math.max(dpLast1, -price);
        }
        return dpLast0;
    }

}
