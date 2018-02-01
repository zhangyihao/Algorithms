package com.zhangyihao.algorithms.offer;

import com.zhangyihao.algorithms.offer.Question13.ListNode;

public class Question16 {

	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = head.next;
		
		if(next == null) {
			return head;
		}
		
		while(cur != null) {
			cur.next = prev;
			if(next == null) {
				break;
			}
			prev = cur;
			cur = next;
			next = next.next;
		}
		
		return cur;
	}
	
	public void printList(ListNode head) {
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

	public static void main(String[] args) {
		Question13 q = new Question13();

		ListNode node1 = q.new ListNode(1);
		ListNode node2 = q.new ListNode(2);
		ListNode node3 = q.new ListNode(3);
		ListNode node4 = q.new ListNode(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		
		Question16 q16 = new Question16();
		q16.printList(q16.reverseList(node1));
		
		node1.next = null;
		q16.printList(q16.reverseList(node1));
		
		q16.printList(q16.reverseList(null));
	}

}
