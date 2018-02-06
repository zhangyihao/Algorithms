package com.zhangyihao.algorithms.offer;

public class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
	
	/**
	 * 先序遍历， NLR
	 * @param node
	 */
	public static void preorderTraversal(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.val+",");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	/**
	 * 中序遍历，LNR
	 * @param node
	 */
	public static void inorderTraversal(TreeNode node) {
		if(node == null) {
			return;
		}
		
		inorderTraversal(node.left);
		System.out.print(node.val+",");
		inorderTraversal(node.right);
	}
	
	/**
	 * 后序遍历，LRN
	 */
	public static void postorderTraversal(TreeNode node) {
		if(node == null) {
			return;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.val+",");
	}
}