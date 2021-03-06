package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序（稳定排序），时间复杂读O(n^2)
 * @author zhangyihao
 *
 */
public class BubbleSort {

	/**
	 * 大数下沉
	 * @param array
	 */
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
	
	/**
	 * 小数上浮
	 * @param array
	 */
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

}
