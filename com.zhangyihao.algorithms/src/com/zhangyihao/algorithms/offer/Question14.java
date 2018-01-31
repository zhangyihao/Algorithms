package com.zhangyihao.algorithms.offer;

import java.util.Arrays;

/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分。
 * @author zhangyihao
 *
 */
public class Question14 {

	public void reOrder(int [] array) {
        int start = 0;
        int end = array.length-1;
        
        while(start < end) {
        	while((array[start] & 1) != 0) {
        		start++;
        	}
        	
        	while((array[end] & 1) ==0) {
        		end--;
        	}
        	
        	if(start < end) {
        		int temp = array[start];
        		array[start] = array[end];
        		array[end] = temp;
        	}
        }
    }
	
	//保证奇数和奇数，偶数和偶数之间的相对位置不变。
	public void reOrderArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			int index = i;
			while(index<array.length && (array[index] & 1) ==0) {
				index++;
			}
			
			//找到最后没有找到奇数，说明剩下的全是偶数，数组已调整完成
			if(index >= array.length) {
				break;
			}
			
			int odd = array[index];
			for(int start=index; start>i; start--) {
				array[start] = array[start-1];
			}
			array[i] = odd;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 0, -1, 6, 3, 5};
//		int[] array = {1, 3, 5, 2, 4, 6, 8};
		Question14 q = new Question14();
//		q.reOrder(array);
		
		q.reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}

}
