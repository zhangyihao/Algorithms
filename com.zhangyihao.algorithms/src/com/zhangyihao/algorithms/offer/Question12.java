package com.zhangyihao.algorithms.offer;

/**
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。
 * 比如输入3，则打印出1、2、3一直到最大的三位数999。
 * @author zhangyihao
 *
 */
public class Question12 {
	
	public void printDigits(int n) {
		if(n <=0 ) {
			System.out.println("n需要大于0");
			return;
		}
		int[] digits = new int[n];
		printDigits(digits, 0);
	}

	private void printDigits(int[] digits, int n) {
		if(n >= digits.length) {
			printArray(digits);
			return;
		}
		for(int i=0; i<=9; i++) {
			digits[n] = i;
			printDigits(digits, n+1);
		}
	}
	
	private void printArray(int[] digits) {
		int index = 0;
		while(index<digits.length) {
			if(digits[index] != 0) {
				break;
			}
			index++;
		}
		if(index >= digits.length) {
			return;
		}
		for(int i=index; i<digits.length; i++) {
			System.out.print(digits[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Question12 q = new Question12();
		q.printDigits(3);
	}

}
