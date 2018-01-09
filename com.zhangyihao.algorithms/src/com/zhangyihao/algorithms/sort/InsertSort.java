package com.zhangyihao.algorithms.sort;

public class InsertSort {
	
	public int[] sort(int[] array) {
		
		for(int i=1; i<array.length; i++) {
			int temp = array[i];
			for(int j=0; j<i; j++) {
				if(array[j] > temp) {
					for(int startIndex=i; startIndex>j; startIndex--) {
						array[startIndex] = array[startIndex-1];
					}
					array[j] = temp;
					break;
				}
			}
		}
		
		return array;
	}
}
