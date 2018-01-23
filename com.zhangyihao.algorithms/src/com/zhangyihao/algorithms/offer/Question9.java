package com.zhangyihao.algorithms.offer;

/**
 * 题目描述：现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * 
 * @author zhangyihao
 *
 */
public class Question9 {

	public int Fibonacci(int n) {
		if (n < 0) {
			return -1;
		}
		int f1 = 0;
		int f2 = 1;
		int f3 = 1;

		if (n == 0) {
			return f1;
		}

		if (n == 1) {
			return f2;
		}

		while (n>=2) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
			n--;
		}
		
		return f3;
	}
	
	public int Fibonacci2(int n) {
		if (n < 0) {
			return -1;
		}
		int f1 = 0;
		int f2 = 1;

		if (n == 0) {
			return f1;
		}

		if (n == 1) {
			return f2;
		}

		while(n>=2) {
			f2 = f2 + f1;
			f1 = f2 - f1;
			n--;
		}

		return f2;
	}

	public int Fibonacci_Reversion(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Question9 q = new Question9();
		int n = 14;
		System.out.println(q.Fibonacci(n));
		System.out.println(q.Fibonacci2(n));
		System.out.println(q.Fibonacci_Reversion(n));

	}
}
