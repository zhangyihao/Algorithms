package com.zhangyihao.algorithms.offer;

/**
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author zhangyihao
 *
 */
public class Question9_2 {

	public int JumpFloorII(int n) {
		if (n < 1) {
			return 0;
		}
		return 1 << (n - 1);
	}

	public int JumpFloorII1(int n) {
		if (n < 1) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		// f(n)=2*f(n-1)
		int f1 = 1;
		int f2 = 0;
		while (n >= 2) {
			f2 = 2 * f1;
			f1 = f2;
			n--;
		}
		return f2;
	}

	public static void main(String[] args) {
		int n = 8;
		System.out.println(new Question9_2().JumpFloorII(n));
		System.out.println(new Question9_2().JumpFloorII1(n));
	}
}
