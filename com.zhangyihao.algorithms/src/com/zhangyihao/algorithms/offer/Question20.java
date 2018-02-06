package com.zhangyihao.algorithms.offer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author zhangyihao
 *
 */
public class Question20 {

	public ArrayList<Integer> printMatrix(int [][] matrix) {
		if(matrix == null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
		
		for(int start=0; start*2<matrix.length && start*2<matrix[0].length; start++) {
			int endCol = matrix[0].length -1 - start;
			int endRow = matrix.length - 1 - start;
			
			for(int i=start; i<=endCol; i++) {
				result.add(matrix[start][i]);
			}
			
			for(int row=start+1; row<=endRow; row++) {
				result.add(matrix[row][endCol]);
			}
			
			if(start < endRow) {
				for(int col=endCol-1; col>=start ;col--) {
					result.add(matrix[endRow][col]);
				}
			}
			
			for(int row=endRow-1; row>start; row--) {
				result.add(matrix[row][start]);
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		Question20 q = new Question20();
		
		int[][] m = {{1}};
		System.out.println(q.printMatrix(m).toString());
		
		//2行n列，只有一圈
		int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}}; 
		System.out.println(q.printMatrix(matrix).toString());
		
		//n行2列，只有一圈
		int[][] matrix1 = {{1, 2}, {3, 4}, {5, 6}};
		System.out.println(q.printMatrix(matrix1).toString());
		
		//3行3列,最后一圈只有一个数
		int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(q.printMatrix(m1).toString());
		
		//3行5列，最后 一圈只有一行
		int[][] m2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
		System.out.println(q.printMatrix(m2).toString());
		
		//4行5列，最后一圈只有两行
		int[][] m3 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
		System.out.println(q.printMatrix(m3).toString());
	}

}
