package com.zhangyihao.algorithms.leetcode.q0053;

import com.zhangyihao.algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 94. 二叉树中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author zhangyihao
 * @date 2022/3/9
 */
public class Solution94 {

    /**
     * 递归方式
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root 根节点
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        this.inorderTraversalRecursion(root, nodeList);
        return nodeList;
    }

    /**
     * 递归方式
     * @param node 根节点
     * @param nodeList  中序遍历结果集合
     */
    private void inorderTraversalRecursion(TreeNode node, List<Integer> nodeList) {
        if (node == null) {
            return;
        }
        inorderTraversalRecursion(node.left, nodeList);
        nodeList.add(node.val);
        inorderTraversalRecursion(node.right, nodeList);
    }

    /**
     * Morris 法
     * 空间复杂度降为 O(1)
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversalMorris() {
        return null;
    }


    private void test1() {
        TreeNode left = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, null);

        root = new TreeNode(1, null, root);
        // [1, 3, 2]
        System.out.println(Arrays.toString(this.inorderTraversal(root).toArray()));
    }

    private void test2() {
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, null);
        // [2, 1]
        System.out.println(Arrays.toString(this.inorderTraversal(root).toArray()));
    }

    private void test3() {
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, right);
        // [1, 2]
        System.out.println(Arrays.toString(this.inorderTraversal(root).toArray()));
    }

    public static void main(String[] args) {
        Solution94 t = new Solution94();
        t.test1();
        t.test2();
        t.test3();
    }



}
