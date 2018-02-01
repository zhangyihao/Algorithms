package com.zhangyihao.algorithms.offer;

public class Question17 {

	/**
	 * 递归方法
	 * @param firstHead
	 * @param secondHead
	 * @return
	 */
	public ListNode merge(ListNode firstHead, ListNode secondHead) {
		if (firstHead == null) {
			return secondHead;
		} else if (secondHead == null) {
			return firstHead;
		}
		ListNode pMergeHead = null;
		if (firstHead.value < secondHead.value) {
			pMergeHead = firstHead;
			pMergeHead.next = merge(firstHead.next, secondHead);
		} else {
			pMergeHead = secondHead;
			pMergeHead.next = merge(firstHead, secondHead.next);
		}
		return pMergeHead;
	}

	public ListNode merge2List(ListNode firstHead, ListNode secondHead) {
		if (firstHead == null && secondHead == null) {
			return null;
		}

		if (firstHead == null && secondHead != null) {
			return secondHead;
		}

		if (firstHead != null && secondHead == null) {
			return firstHead;
		}

		ListNode head = null;
		ListNode head1 = firstHead;
		ListNode head2 = secondHead;
		if (firstHead.value >= secondHead.value) {
			head = secondHead;
			head2 = secondHead.next;
		} else {
			head = firstHead;
			head1 = firstHead.next;
		}

		ListNode curNode = head;

		while (head1 != null && head2 != null) {
			if (head1.value >= head2.value) {
				curNode.next = head2;
				curNode = head2;
				head2 = head2.next;
			} else {
				curNode.next = head1;
				curNode = head1;
				head1 = head1.next;
			}
		}

		if (head1 != null) {
			curNode.next = head1;
		}

		if (head2 != null) {
			curNode.next = head2;
		}

		return head;
	}

	public static void main(String[] args) {
		int[] array1 = new int[] { 2, 5, 7, 9, 12, 14, 15 };
		int[] array2 = new int[] { 1, 3, 4, 6, 6, 9, 10 };
		Question17 q = new Question17();

		ListNode first = ListNode.createList(array1);
		ListNode second = ListNode.createList(array2);

//		ListNode.printList(q.merge2List(first, second));
		ListNode.printList(q.merge(first, second));

		second = ListNode.createList(array2);
//		ListNode.printList(q.merge2List(null, second));
		ListNode.printList(q.merge(null, second));

		first = ListNode.createList(array1);
//		ListNode.printList(q.merge2List(first, null));
//		ListNode.printList(q.merge2List(null, null));
		
		ListNode.printList(q.merge(first, null));
		ListNode.printList(q.merge(null, null));
	}

}
