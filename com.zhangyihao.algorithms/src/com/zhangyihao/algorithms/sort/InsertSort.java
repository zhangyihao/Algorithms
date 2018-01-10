package com.zhangyihao.algorithms.sort;

public class InsertSort {
	
	public int[] sort(int[] array) {
		for(int i=1; i<array.length; i++) {
			int temp = array[i];
			for(int j=0; j<i; j++) {
				//在已排序序列中找到一个比temp大的元素
				if(array[j] > temp) {
					//将较大元素（包括较大元素自身）往后的所有已排序序列中的元素向后移动
					for(int startIndex=i; startIndex>j; startIndex--) {
						array[startIndex] = array[startIndex-1];
					}
					//将temp插入到较大元素位置
					array[j] = temp;
					break;
				}
			}
		}
		
		return array;
	}
}
