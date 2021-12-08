package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序，不稳定排序，平均时间复杂度为O(nlogn)
 * 
 * @author zhangyihao
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		System.out.println(Arrays.toString(sort.sort(new int[]{ 5, 1, 1, 2, 0, 0, 3, 1 })));
//		System.out.println(Arrays.toString(sort.sort(new int[]{ 2, 3})));
	}

	public int[] sort(int[] array) {
		this.sort(array, 0, array.length - 1);
		return array;
	}

	private void sort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}

		int base = array[start];
		int low = start;
		int high = end;

		while(true) {
			// 从右侧开始，找到第一个比基数小的数
			while (low < high && array[high] > base) {
				high--;
			}
			// 从左开始，找到第一个比基数大的数
			while (low < high && array[low] <= base) {
				low++;
			}
			// 如果指针相遇，说明
			if (low >= high) {
				break;
			}
			// 交换两个数
			swap(array, low, high);
		}
		this.swap(array, start, low);

		this.sort(array, start, low - 1);
		this.sort(array, low + 1, end);
	}

	private void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}


}
