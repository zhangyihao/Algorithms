package com.zhangyihao.algorithms.leetcode;

/**
 * FriendCircleDfs
 *
 * 思路：深度优先遍历。
 * 从第一个节点开始依次对每个节点进行遍历，过程如下：
 *   1）若该节点已被遍历过，表示已经加入某个朋友圈，不需要进行深度遍历。
 *   2）否则，该节点还未加入任何朋友圈，朋友圈数量+1。然后以该节点开始，进行深度遍历。
 * 重复上述步骤，直至每个节点都被遍历过。
 *
 * 其中，深度优先遍历过程：
 *  1）若被遍历节点为遍历过且两个节点间是朋友关系，则以被遍历节点为开始节点进行深度优先遍历。
 *  2）否则，遍历下个节点。
 *  说明：经过一轮的深度优先遍历，则会将开始节点是朋友关系的节点标记为“已遍历”。
 *
 * @author zhangyihao1
 * @Date 2019/7/6
 */
public class FriendCircleDfs {

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            // 如果未被遍历 且是朋友关系，标记为“已遍历”，进行新的深度优先遍历。
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
