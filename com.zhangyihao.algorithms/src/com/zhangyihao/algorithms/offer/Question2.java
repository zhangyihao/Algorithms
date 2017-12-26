package com.zhangyihao.algorithms.offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author zhangyihao
 *
 */
public class Question2 {

	public boolean find(int target, int[][] array) {
		if(array == null || array.length == 0) {
			return false;
		}
		int rowLength = array.length;
		int colLength = array[0].length;
		
		boolean find = false;
//		for(int col=colLength-1, row=0; col>=0 && row<rowLength;) {
//			int num = array[row][col];
//			if(num == target) {
//				find = true;
//				break;
//			}else if (num<target) {
//				row++;
//			} else {
//				col--;
//			}
//		}
		
		for(int col=0, row=rowLength-1; col<colLength && row>=0;) {
			int num = array[row][col];
			if(num == target) {
				find = true;
				break;
			} else if (num < target) {
				col++;
			} else {
				row--;
			}
		}
		
		return find;
	}

	public static void main(String[] args) {
		int[][] data = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		int[][] data = { { 1, 6, 8, 13, 20 }, {2,9,11,18,23}, {5,10,12,20,24}, {7,16,17,24,25}, {10,19,21,26,27}};
		System.out.println(new Question2().find(20, data));
	}

}
