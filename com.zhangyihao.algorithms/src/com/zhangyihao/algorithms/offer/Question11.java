package com.zhangyihao.algorithms.offer;

/**
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 不得使用库函数，不用考虑大数问题。
 * @author zhangyihao
 *
 */
public class Question11 {

	/**
	 * a^n = a^(n/2) * a^(n/2) (n为偶数)
	 * a^n = a^((n-1)/2) * a^((n-1)/2) * a (n为奇数)
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double Power(double base, int exponent) {
		if(exponent == 0) {
			return 1;
		}
		if(exponent == 1) {
			return base;
		}
		
		double result = Power(base, (exponent<0?-exponent:exponent)>>1);
		result *= result;
		
		//如果为基数
		if((exponent & 1) == 1) {
			result *= base;
		}
		
		if(exponent < 0) {
			result = 1.0/result;
		}
		
		return result;
	}

	public static void main(String[] args) {
		Question11 q = new Question11();
		
		System.out.println(q.Power(3, 3));
		System.out.println(q.Power(3, 0));
		System.out.println(q.Power(3, -3));
	}

}
