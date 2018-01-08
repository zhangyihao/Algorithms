package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

public class HeapSort {

	public int[] sort(int[] array) {
		int length = array.length;
		while (length > 1) {
			initHeap(array, length);

			System.out.println("初始化堆结果：" + Arrays.toString(array));

			int temp = array[length - 1];
			array[length - 1] = array[0];
			array[0] = temp;

			System.out.println("排序结果：" + Arrays.toString(array));
			length--;
		}
		return array;
	}

	private void initHeap(int[] array, int length) {
		// 从最后一个非叶子结点的父结点开始
		for (int i = (length - 2) / 2; i >= 0; i--) {
			int parent = i;
			int parentValue = array[parent]; // 记录下parent的值
			int maxChild = 2 * parent + 1; // 先选取左结点为大结点

			while (maxChild < length) {
				// 如果有右结点且右结点大于左结点，选取右结点为大结点
				if ((maxChild + 1) < length && array[maxChild] < array[maxChild + 1]) {
					maxChild++;
				}

				// 如果大结点小于父结点直接结束
				if (array[maxChild] <= parentValue) {
					break;
				}

				// 将大结点的值赋值给父结点
				array[parent] = array[maxChild];
				// 发生交换后，继续调整已大结点为根结点的树
				parent = maxChild;
				maxChild = 2 * parent + 1;
			}

			array[parent] = parentValue;
		}
	}

}
