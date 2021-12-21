package com.zhangyihao.algorithms.leetcode.q0118;

import java.util.*;

/**
 * 102 二叉树的层序遍历
 *
 * @author zhangyihao
 * @date 2021/12/21
 */
public class Lee102 {

    public static void main(String[] args) {
        Lee102 t = new Lee102();

        TreeNode nodeL = t.new TreeNode(15, t.new TreeNode(16), t.new TreeNode(17));
        TreeNode nodeR = t.new TreeNode(7, null, t.new TreeNode(8));

        TreeNode nodeR2 = t.new TreeNode(20, nodeL, nodeR);

        TreeNode root = t.new TreeNode(3, t.new TreeNode(9), nodeR2);

        List<List<Integer>> result = t.levelOrder(root);
        System.out.println(Arrays.toString(result.toArray()));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodeList = new ArrayList<>();
        if (root != null) {
            // 队列，记录每层节点
            Queue<TreeNode> queue = new LinkedList<>();
            // 根节点入队
            queue.add(root);

            TreeNode node;
            List<Integer> nodeValueList;
            int queueSize;
            while (!queue.isEmpty()) {
                queueSize = queue.size();
                nodeValueList = new ArrayList<>(queueSize);
                // 循环遍历当前层的节点
                for (int i = 0; i < queueSize; i++) {
                    node = queue.poll();
                    if (node == null) {
                        continue;
                    }
                    nodeValueList.add(node.val);
                    // 将子节点入队
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                nodeList.add(nodeValueList);
            }
        }
        return nodeList;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
