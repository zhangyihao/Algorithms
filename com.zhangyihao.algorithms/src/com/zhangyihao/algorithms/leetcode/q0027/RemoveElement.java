package com.zhangyihao.algorithms.leetcode.q0027;

/**
 * 27. 移除元素
 *
 * @author zhangyihao
 */
public class RemoveElement {

    public static void main(String[] args) {
//        RemoveElement t = new RemoveElement();
        RemoveElement3 t = new RemoveElement3();
        System.out.println(t.removeElement(new int[]{}, 3));
        System.out.println(t.removeElement(new int[]{3}, 3));
        System.out.println(t.removeElement(new int[]{2}, 3));
        System.out.println(t.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(t.removeElement(new int[]{3, 3, 3, 2, 3, 3}, 3));
        System.out.println(t.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        // i 记录和 val 相等的位置，j 记录和 val 不相等的位置
        int i = 0, j = 0;
        while(j < nums.length) {
            if(nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

}
