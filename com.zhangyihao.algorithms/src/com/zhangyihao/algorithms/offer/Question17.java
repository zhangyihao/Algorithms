package com.zhangyihao.algorithms.offer;

import com.zhangyihao.algorithms.offer.Question13.ListNode;

public class Question17 {

	public ListNode merge2List(ListNode firstHead, ListNode secondHead) {
		
		if(firstHead == null && secondHead == null) {
			return null;
		}
		
		if(firstHead == null && secondHead != null) {
			return firstHead;
		}
		
		if(firstHead !=null && secondHead == null) {
			return secondHead;
		}
		
		ListNode head = null;
		ListNode head1 = firstHead;
		ListNode head2 = secondHead;
		if(firstHead.value >= secondHead.value) {
			head = firstHead;
			head1 = firstHead.next;
		} else {
			head = secondHead;
			head2 = secondHead.next;
		}
		
		ListNode curNode = head;
		
		while(head1 != null && head2 != null) {
			if(head1.value >= head2.value) {
				curNode.next = head1;
				curNode = head1;
				head1 = head1.next;
			} else {
				curNode.next = head2;
				curNode = head2;
				head2 = head2.next;
			}
		}
		
		if(head1 != null) {
			curNode.next = head1;
		}
		
		if(head2 != null) {
			curNode.next = head2;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
