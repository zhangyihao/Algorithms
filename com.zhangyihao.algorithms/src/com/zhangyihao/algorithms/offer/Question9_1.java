package com.zhangyihao.algorithms.offer;

/**
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author zhangyihao
 *
 */
public class Question9_1 {

	public int Fibonacci(int n) {
		if (n <= 0) {
			return -1;
		}
		int f1 = 1;
		int f2 = 2;
		int f3 = 1;

		if (n == 1) {
			return f1;
		}

		if (n == 2) {
			return f2;
		}

		//f(n)=f(n-1)+f(n-2)
		while (n>=3) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
			n--;
		}
		
		return f3;
	}
	
	public static void main(String[] args) {
		Question9_1 q = new Question9_1();
		System.out.println(q.Fibonacci(4));

	}
}
