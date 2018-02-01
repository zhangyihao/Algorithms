package com.zhangyihao.algorithms.offer;

public class ListNode {
	int value;
	ListNode next;

	ListNode(int val) {
		this.value = val;
	}
	
	public static ListNode createList(int[] array) {
		if(array == null || array.length ==0) {
			return null;
		}
		
		ListNode head = new ListNode(array[0]);
		ListNode prev = head;
		for(int i=1; i<array.length; i++) {
			ListNode curr = new ListNode(array[i]);
			prev.next = curr;
			prev = curr;
		}
		return head;
	}
	
	public static void printList(ListNode head) {
		if(head==null) {
			System.out.println("null");
			return;
		}
		
		ListNode cur = head;
		while(true) {
			System.out.print(cur.value);
			cur = cur.next;
			if(cur==null) {
				break;
			}
			System.out.print("->");
		}
		System.out.println();
	}
}