package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

	public int[] sort(int[] array) {
		mergeSort(array, 0, array.length-1);
		return array;
	}
	
	private void mergeSort(int[] array, int start, int end) {
		if(start == end) {
			return;
		}
		int middle = (start + end)/2;
		System.out.println("分："+Arrays.toString(array)+start+","+middle+","+end);
		mergeSort(array, start, middle); //对分割后的序列排序
		mergeSort(array, middle+1, end);
		merge(array, start, middle, end); //合并两个序列
	}
	
	private void merge(int[] array, int start, int middle, int end) {
		int[] newArray = new int[end-start+1];
		
		int newIndex =0;
		int index1 = start;
		int index2 = middle+1;
		
		//依次比较两个序列中的首元素，将小的赋值到新的序列中
		while(index1<=middle && index2<=end) {
			if(array[index1]<=array[index2]) {
				newArray[newIndex] = array[index1];
				index1++;
			} else {
				newArray[newIndex] = array[index2];
				index2++;
			}
			newIndex++;
		}
		
		//将两个序列中剩余的元素一次赋值到新序列中
		while(index1<=middle) {
			newArray[newIndex] = array[index1];
			index1++;
			newIndex++;
		}
		
		while(index2<=end) {
			newArray[newIndex] = array[index2];
			index2++;
			newIndex++;
		}
		
		for(int i=start, j=0; i<=end; i++,j++) {
			array[i] = newArray[j];
		}
		
		System.out.println("合："+Arrays.toString(newArray)+start+","+middle+","+end);
	}
}
