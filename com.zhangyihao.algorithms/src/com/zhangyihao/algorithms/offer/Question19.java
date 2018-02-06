package com.zhangyihao.algorithms.offer;

/**
 * 二叉树的镜像
 * @author zhangyihao
 *
 */
public class Question19 {

	public void Mirror(TreeNode root) {
		if(root == null) {
			return;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		Mirror(root.left);
		Mirror(root.right);
	}
	
	public TreeNode mirror(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		TreeNode newNode = new TreeNode(node.val);
		newNode.left = mirror(node.right);
		newNode.right = mirror(node.left);
		
		return newNode;
	}

	public static void main(String[] args) {
		Question6 q = new Question6();
		Question19 q19 = new Question19();
		
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8, 9};
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6, 9};
		TreeNode root = q.reConstructBinaryTree(pre, in);
		TreeNode.preorderTraversal(q19.mirror(root));
		System.out.println();
		
		q19.Mirror(root);
		TreeNode.preorderTraversal(root);
		System.out.println();
		System.out.println("-----");
		
		int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};  
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        root = q.reConstructBinaryTree(preorder, inorder);
        TreeNode.preorderTraversal(q19.mirror(root));
        System.out.println();

        q19.Mirror(root);
		TreeNode.preorderTraversal(root);
		System.out.println();
		System.out.println("-----");
        
        //所有节点没有右节点
        int[] preorder1 = {1, 2, 3, 4, 5};  
        int[] inorder1 = {5, 4, 3, 2, 1};
        root = q.reConstructBinaryTree(preorder1, inorder1);
        TreeNode.preorderTraversal(q19.mirror(root));
        System.out.println();
        
		q19.Mirror(root);
		TreeNode.preorderTraversal(root);
		System.out.println();
		System.out.println("-----");
        
        //所有节点没有左节点
        int[] preorder2 = {1, 2, 3, 4, 5};  
        int[] inorder2 = {1, 2, 3, 4, 5};
        root = q.reConstructBinaryTree(preorder2, inorder2);
        TreeNode.preorderTraversal(q19.mirror(root));
        System.out.println();
        
		q19.Mirror(root);
		TreeNode.preorderTraversal(root);
		System.out.println();
        System.out.println("-----");
        
        //完全二叉树
        int[] preorder3 = {1, 2, 4, 5, 3, 6, 7};  
        int[] inorder3 = {4, 2, 5, 1, 6, 3, 7};
        root = q.reConstructBinaryTree(preorder3, inorder3);
        TreeNode.preorderTraversal(q19.mirror(root));
        System.out.println();
        
		q19.Mirror(root);
		TreeNode.preorderTraversal(root);
		
	}

}
