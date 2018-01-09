package com.zhangyihao.algorithms.sort;

import java.util.Arrays;

public class HeapSort2 {
	private static void adjustHeat(int[] array, int parent, int length) {
		// parentValue保存当前父节点
		int parentValue = array[parent];
		// 先选取左结点为大结点
		int maxChild = 2 * parent + 1;

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
			// 发生交换后，继续调整以大结点为根结点的树
			parent = maxChild;
			maxChild = 2 * parent + 1;
		}
		array[parent] = parentValue;
	}

	public void sort(int[] array) {
		// 循环建立初始堆
		for (int i = (array.length - 2) / 2; i >= 0; i--) {
			adjustHeat(array, i, array.length);
		}

		// 进行n-1次循环，完成排序
		for (int length = array.length - 1; length > 0; length--) {
			// 最后一个元素和第一元素进行交换
			int temp = array[length];
			array[length] = array[0];
			array[0] = temp;

			System.out.println(String.format("第 %d 趟排序结果：", array.length - length) + Arrays.toString(array));

			// 将剩下数组总元素组成的堆继续调整
			adjustHeat(array, 0, length);
		}
	}
}
