package com.zhangyihao.algorithms.offer;

/**
 * 输入两颗二叉树A和B，判断B是不是A的子结构
 * @author zhangyihao
 *
 */
public class Question18 {

	/**
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if(root1 !=null && root2 != null) {
			if(root1.val == root2.val) {
				//如果根节点相同，则判断 以root1为根节点的子树和树B（以root2为根节点）结构是否相同
				result = doesTree1hasTree2(root1, root2);
			}
			
			//如果根节点不同或 以root1为根节点的子树和树B结构不同，则在root1的左子树中继续查找
			if(!result) {
				result = HasSubtree(root1.left, root2);
			}
			
			//如果左子树中也没有，就在右子树中查找。
			if(!result) {
				result = HasSubtree(root1.right, root2);
			}
			
		}
		return result;
	}
	
	private boolean doesTree1hasTree2(TreeNode root1, TreeNode root2) {
		if(root2 == null) {
			return true;
		}
		
		if(root1 == null) {
			return false;
		}
		
		//如果两个节点不相同，则结构不同
		if(root1.val != root2.val) {
			return false;
		}
		
		//递归判断两个数的左右子树结构是否相同
		return doesTree1hasTree2(root1.left, root2.left) && doesTree1hasTree2(root1.right, root2.right);
	}

}
