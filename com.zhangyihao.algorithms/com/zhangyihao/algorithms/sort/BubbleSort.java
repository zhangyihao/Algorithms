package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

	public void sort(int[] array) {
		//控制总共循环次数
		for(int i=1; i<=array.length; i++) {
			for(int j=0; j<array.length-i; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
			System.out.println("第"+i+"趟排序结果："+Arrays.toString(array));
		}
	}
	
	public void sort2(int[] array) {
		for(int i=1; i<=array.length; i++) {
			for(int j=array.length-1; j>=i; j--) {
				if(array[j] <= array[j-1]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
			System.out.println("第"+i+"趟排序结果："+Arrays.toString(array));
		}
	}
	
	public static void main(String[] args) {
		int array[] = {3,4,63,4,-9,0,1,32,-2, 21};
		
		BubbleSort sort = new BubbleSort();
		sort.sort(array);
	}

}
