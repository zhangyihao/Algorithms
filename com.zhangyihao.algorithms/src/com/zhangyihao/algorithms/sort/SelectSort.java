package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

public class SelectSort {

	public int[] sort(int[] array) {
		for(int i=0; i<array.length-1; i++) {
			int min = array[i];
			int minIndex = i;
			//从待排序序列中选择一个值最小的元素
			for(int j=i+1; j<array.length; j++) {
				if(min > array[j]) {
					min = array[j];
					minIndex = j;
				}
			}
			
			//待排序序列第一个元素和最小元素交换
			if(i < minIndex) {
				array[minIndex]  = array[i];
				array[i] = min;
			}
			System.out.println((i+1)+":"+Arrays.toString(array));
		}
		
		return array;
	}
	
}
