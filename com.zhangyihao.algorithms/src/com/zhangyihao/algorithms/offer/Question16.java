package com.zhangyihao.algorithms.offer;

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
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		
		Question16 q16 = new Question16();
		ListNode.printList(q16.reverseList(node1));
		
		node1.next = null;
		ListNode.printList(q16.reverseList(node1));
		
		ListNode.printList(q16.reverseList(null));
	}

}
