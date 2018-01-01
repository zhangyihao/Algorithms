package com.zhangyihao.algorithms.offer;

import java.util.ArrayList;

/**
 * 面试题5
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * @author zhangyihao
 *
 */
public class Question5 {
	
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if(listNode == null) {
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		temp.add(listNode.val);
		ListNode next = listNode.next;
		while(next != null) {
			temp.add(next.val);
			next = next.next;
		}
		ArrayList<Integer> result = new ArrayList<>(temp.size());
		for(int i=temp.size()-1; i>=0; i--) {
			result.add(temp.get(i));
		}
		return result;
	}

	public static void main(String[] args) {
		Question5 q = new Question5();
		ListNode node1 = q.new ListNode(67);
		ListNode node2 = q.new ListNode(0);
		ListNode node3 = q.new ListNode(24);
		ListNode node4 = q.new ListNode(58);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		
		System.out.println(q.printListFromTailToHead(node1).toString());
	}

}

