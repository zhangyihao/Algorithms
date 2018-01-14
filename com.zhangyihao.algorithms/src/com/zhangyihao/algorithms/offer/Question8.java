package com.zhangyihao.algorithms.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * @author zhangyihao
 *
 */
public class Question8 {

	public int minNumberInRotateArray(int [] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		
		int index1 = 0;
		int index2 = array.length-1;
		int midIndex = -1;
		
		while(index1 < index2) {
			if(index2 - index1 == 1) {
				midIndex = index2;
				break;
			}
			
			midIndex = (index1 + index2)/2;
			
			if(array[index1] == array[midIndex] && array[index2] == array[midIndex]) {
				return findInOrder(array, index1, index2);
			} else if (array[index1] <= array[midIndex]) {
				index1 = midIndex;
			} else {
				index2 = midIndex;
			}
		}
		
		if(midIndex == -1) {
			System.out.println("error");
		}
		
	    return array[midIndex];
    }
	
	private int findInOrder(int[] array, int start, int end) {
		int temp = array[start];
		for(int i=start+1; i<=end; i++) {
			if(array[i] < temp) {
				temp = array[i];
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
//		int[] array = {3,4,5,1,2};
//		int[] array = {1,0,1,1,1};
		int[] array = {1,1,1,0,1};
		System.out.println(new Question8().minNumberInRotateArray(array));
	}

}
