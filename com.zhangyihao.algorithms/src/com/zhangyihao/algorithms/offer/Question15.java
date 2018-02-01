package com.zhangyihao.algorithms.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾结点是倒数第一个结点。例如一个链表有6个结点，从头结点开始他们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个结点是值为4的结点。
 * @author zhangyihao
 *
 */
public class Question15 {

	public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k<1) {
			return null;
		}
		
		ListNode first = head;
		ListNode second = head;
		
		for(int i=1; i<k; i++) {
			if(first.next == null) {
				second = null;
				break;
			}
			first = first.next;
		}
		
		while(first.next!=null) {
			first = first.next;
			second = second.next;
		}
		
		return second;
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
		
		Question15 q15 = new Question15();
		ListNode node = q15.FindKthToTail(node1, 1);
		System.out.println(node==null?"null":node.value);
		
		node = q15.FindKthToTail(node1, 4);
		System.out.println(node==null?"null":node.value);
		
		node = q15.FindKthToTail(node1, 3);
		System.out.println(node==null?"null":node.value);
		
		node = q15.FindKthToTail(node1, 6);
		System.out.println(node==null?"null":node.value);
		
		node = q15.FindKthToTail(null, 1);
		System.out.println(node==null?"null":node.value);
	}

}
