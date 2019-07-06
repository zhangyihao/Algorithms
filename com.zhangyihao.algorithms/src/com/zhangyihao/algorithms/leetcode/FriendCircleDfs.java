package com.zhangyihao.algorithms.leetcode;

/**
 * FriendCircleDfs
 *
 * 思路：深度优先遍历
 *
 * @author zhangyihao1
 * @Date 2019/7/6
 */
public class FriendCircleDfs {

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (visited[j] == 0 && M[i][j] == 1) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
