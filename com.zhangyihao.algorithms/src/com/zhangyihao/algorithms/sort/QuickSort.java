package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序，不稳定排序，平均时间复杂度为O(nlogn)
 * 
 * @author zhangyihao
 *
 */
public class QuickSort {

	public static int[] sort(int[] array, int start, int end) {
		if (start < 0 || end > array.length - 1) {
			return array;
		}
		int k = array[start];
		int i = start;
		int j = end;
		while (i < j) {
			while (i < j) {
				if (k > array[j]) {
					array[i] = array[j];
					i++;
					break;
				}
				j--;
			}
			while (i < j) {
				if (k < array[i]) {
					array[j] = array[i];
					j--;
					break;
				}
				i++;
			}
			
//			while(i<j && k<=array[j]) {
//				j--;
//			}
//			if(i<j) {
//				array[i] = array[j];
//				i++;
//			}
//			
//			while(i<j && k>=array[i]) {
//				i++;
//			}
//			if(i<j) {
//				array[j] = array[i];
//				j--;
//			}
		}
		array[i] = k;
		System.out.println(Arrays.toString(array));
		if (start < i - 1) {
			sort(array, start, i - 1);
		}
		if (i + 1 < end) {
			sort(array, i + 1, end);
		}
		return array;
	}

	public static int[] quicksort(int[] a, int left, int right) {
		int i, j, t, temp;
		if (left >= right)
			return a;

		temp = a[left];
		i = left;
		j = right;
		while (i != j) {
			// 顺序很重要，要先从右边开始找
			while (a[j] >= temp && i < j) {
				j--;
			}
			// 再找右边的
			while (a[i] <= temp && i < j) {
				i++;
			}
			// 交换两个数在数组中的位置
			if (i < j) {
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		// 最终将基准数归位
		a[left] = a[i];
		a[i] = temp;

		quicksort(a, left, i - 1);// 继续处理左边的，这里是一个递归的过程
		quicksort(a, i + 1, right);// 继续处理右边的 ，这里是一个递归的过程
		return a;
	}

}
