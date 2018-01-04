package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

public class TestSort {

	public static void main(String[] args) {
		int array[] = { 3, 4, 63, 4, 0, 1, 32, -2, 21 };
//		int array[] = { 6, 1, 5, 4, 8, 3, 9, 12, 51, 11, 15, 14, 13, 25, 69, 47, 56, 74, 26, 78, 22 };
		
//		BubbleSort sort = new BubbleSort();
//		sort.sort(array);

//		System.out.println(Arrays.toString(QuickSort.sort(array, 0, array.length - 1)));
//		System.out.println(Arrays.toString(QuickSort.quicksort(array, 0, array.length - 1)));
		System.out.println(Arrays.toString(new SelectSort().sort(array)));
	}

}
