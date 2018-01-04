package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

public class SelectSort {

	public int[] sort(int[] array) {
		
		for(int i=0; i<array.length-1; i++) {
			int min = array[i];
			int minIndex = i;
			for(int j=i+1; j<array.length; j++) {
				if(min > array[j]) {
					min = array[j];
					minIndex = j;
				}
			}
			
			if(i < minIndex) {
				array[minIndex]  = array[i];
				array[i] = min;
			}
			System.out.println((i+1)+":"+Arrays.toString(array));
		}
		
		return array;
	}
	
}
