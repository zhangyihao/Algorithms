package com.zhangyihao.algorithms.offer;

public class Question10 {

	 public int NumberOf1(int n) {
		 int count = 0;
		 
		 while(n!=0) {
			//判断当前位置是否为1
			 if((n&1)==1) {
				 count++;
			 }
			 
			 //对n进行逻辑右移操作（无符号右移）
			 n=n>>>1;
		 }
		 
		 return count;
	 }
	 
	 public int Numberof12(int n) {
		 int count = 0;
		 int flag = 1;
		 
		 while(flag != 0) {
			 //判断当前位置是否为1
			 if(flag == (n & flag)) {
				 count++;
			 }
			 //对1进行左移操作
			 flag = flag<<1;
		 }
		 
		 return count;
	 }
	 
	 /**
	  * n 和 n-1 进行与操作，能进行多少次与操作，就有多少个1
	  * @param n
	  * @return
	  */
	 public int Numberof13(int n) {
		 int count = 0;
		 
		 while(n != 0) {
			 count++;
			 n = n & (n-1);
		 }
		 
		 return count;
	 }
	
	public static void main(String[] args) {
		Question10 q = new Question10();
		System.out.println(q.Numberof13(-13));
		System.out.println(q.Numberof13(0));
		System.out.println(q.Numberof13(13));
	}

}
