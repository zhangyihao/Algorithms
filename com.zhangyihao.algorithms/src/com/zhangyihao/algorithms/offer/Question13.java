package com.zhangyihao.algorithms.offer;

/**
 * 题目：在O(1)的时间删除链表结点。
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * @author zhangyihao
 *
 */
public class Question13 {

	class ListNode {
		int value;
		ListNode next;
		
		ListNode(int val) {
			this.value = val;
		}
	}
	
	public ListNode deleteNode(ListNode head, ListNode delNode) {
		if(head == null || delNode == null) {
			return null;
		}
		
		//链表中只有一个结点
		if(head == delNode && head.next == null) {
			head = null;
		} else if(delNode.next == null) {
			//删除尾结点
			ListNode currNode = head;
			while(currNode.next != delNode) {
				currNode = currNode.next;
			}
			
			currNode.next = null;
			delNode.next = null;
		} else {
			ListNode next = delNode.next;
			
			delNode.value = next.value;
			delNode.next = next.next;
			
			next.next = null;
		}
		return head;
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

		//删除中间结点
		q.printList(q.deleteNode(node1, node3));
		//删除尾结点
//		q.printList(q.deleteNode(node1, node4));
		
//		node1.next = null;
//		q.printList(q.deleteNode(node1, node1));
	}
	
	private void printList(ListNode head) {
		ListNode cur = head;
		while(cur!=null) {
			System.out.print(cur.value);
			cur = cur.next;
			if(cur!=null) {
				System.out.print("->");
			}
		}
	}

}

