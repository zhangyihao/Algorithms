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
     * 该方法会改变二叉树的结构
     * 空间复杂度降为 O(1)
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        // 大致思路：首先找根节点的前驱节点，也就是根节点的左子树中最右的叶子节点，然后将根节点及根节点的右子树挂到前驱节点下。
        // 此时，左节点变为了整个数的根节点。
        //  1）如果没有左子节点，打印节点，并以右子节点为根节点向下处理。
        //  2) 如果有左子节点，将左子节点当成根节点，重复以上步骤。
        // 也就是说，最终要把树调整成只有右子树的结构，最终退化成一个单链表。
        List<Integer> nodeList = new ArrayList<>();
        TreeNode left;
        while (root != null) {
            left = root.left;
            if (left == null) {
                // 左节点为空，打印根节点，并开始访问右节点
                nodeList.add(root.val);
                root = root.right;
            } else {
                // 左节点不为空，将当前节点及其右子树挂到左子树的最右叶子节点下
                TreeNode preNode = root.left;
                while (preNode.right != null) {
                    preNode = preNode.right;
                }
                preNode.right = root;
                // 将根节点的左节点置为空
                root.left = null;
                // 将左节点当做根节点继续处理
                root = left;
            }
        }
        return nodeList;
    }


    private void test1() {
        TreeNode left = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, null);

        root = new TreeNode(1, null, root);
        // [1, 3, 2]
        System.out.println(Arrays.toString(this.inorderTraversalMorris(root).toArray()));
    }

    private void test2() {
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, null);
        // [2, 1]
        System.out.println(Arrays.toString(this.inorderTraversalMorris(root).toArray()));
    }

    private void test3() {
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, right);
        // [1, 2]
        System.out.println(Arrays.toString(this.inorderTraversalMorris(root).toArray()));
    }

    public static void main(String[] args) {
        Solution94 t = new Solution94();
        t.test1();
        t.test2();
        t.test3();
    }



}
