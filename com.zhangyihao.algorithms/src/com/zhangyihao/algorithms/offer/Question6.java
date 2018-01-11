package com.zhangyihao.algorithms.offer;

/**
 * 题目： 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * @author zhangyihao
 *
 */
public class Question6 {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return reConstructBinaryTree(pre, in, 0, pre.length-1, 0, in.length-1);
	}
	
	private TreeNode reConstructBinaryTree(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn) {
		int rootValue = pre[startPre];
		TreeNode root = new TreeNode(rootValue);
		
		int pos = getIndex(rootValue, in, startIn, endIn);
		if(pos == -1) {
			return null;
		}
		
		int leftEndPre = startPre+(pos-startIn); //起始索引加上长度
//		System.out.print("root:"+rootValue+",");
//		System.out.print("pre:["+(startPre+1)+"-"+leftEndPre+"],["+(leftEndPre+1)+"-"+endPre+"] ");
//		System.out.println("in:["+startIn+"-"+(pos-1)+"],["+(pos+1)+"-"+endIn+"]");
		
		if(pos > startIn) {
			root.left = reConstructBinaryTree(pre, in, startPre+1, leftEndPre, startIn, pos-1);
		}
		if(pos < endIn) {
			root.right = reConstructBinaryTree(pre, in, leftEndPre+1, endPre, pos+1, endIn);
		}
		
		return root;
	}
	
	private int getIndex(int value, int [] array, int start, int end) {
		int index = -1;
		for(int i=start; i<=end; i++) {
			if(array[i] == value) {
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8, 9};
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6, 9};
		
		Question6 q = new Question6();
		printNode(q.reConstructBinaryTree(pre, in));
		System.out.println();
		
		int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};  
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        printNode(q.reConstructBinaryTree(preorder, inorder));
        System.out.println();
        
        //所有节点没有右节点
        int[] preorder1 = {1, 2, 3, 4, 5};  
        int[] inorder1 = {5, 4, 3, 2, 1}; 
        printNode(q.reConstructBinaryTree(preorder1, inorder1));
        System.out.println();
        
        //所有节点没有左节点
        int[] preorder2 = {1, 2, 3, 4, 5};  
        int[] inorder2 = {1, 2, 3, 4, 5};
        printNode(q.reConstructBinaryTree(preorder2, inorder2));
        System.out.println();
        
        //完全二叉树
        int[] preorder3 = {1, 2, 4, 5, 3, 6, 7};  
        int[] inorder3 = {4, 2, 5, 1, 6, 3, 7};
        printNode(q.reConstructBinaryTree(preorder3, inorder3));
	}
	
	private static void printNode(TreeNode node) {
		if(node==null) {
			return;
		}
		printNode(node.left);
		System.out.print(node.val + " ");
		printNode(node.right);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}